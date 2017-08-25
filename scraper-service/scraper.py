import requests
from sumy.parsers.html import HtmlParser
from sumy.nlp.tokenizers import Tokenizer
from sumy.summarizers.lex_rank import LexRankSummarizer as Summarizer
from sumy.nlp.stemmers import Stemmer
from sumy.utils import get_stop_words
from bs4 import BeautifulSoup

class ScrapingResult:
    def __init__(self):
        self.url = None
        self.title = None

class Scraper:

    def scrape(self, url):
        complete_url = url
        try:
            # get title
            print "Retrieving page title of %s... " % complete_url

            # Use requests to get the contents
            r = requests.get(complete_url)

            # Get the text of the contents
            html_content = r.text

            # Convert the html content into a beautiful soup object
            soup = BeautifulSoup(html_content, 'lxml')

            # View the string within the title tag
            title = soup.title.string

            for tag in soup.find_all("meta"):
                if tag.get("property", None) == "og:title":
                    title = tag.get("content", None)

        except Exception, e:
            title = "Could not scrape title. Reason: %s" % e.message

        print "Done: %s = %s" % (url, title)

        # create scraping result
        scraping_result = ScrapingResult()

        scraping_result.url = url
        scraping_result.title = title

        return scraping_result