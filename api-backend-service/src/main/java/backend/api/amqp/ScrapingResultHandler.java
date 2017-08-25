package backend.api.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import backend.api.domain.Bookmark;
import backend.api.domain.BookmarkRepository;

import java.util.List;

@Component
public class ScrapingResultHandler
{
    @Autowired
    private BookmarkRepository bookmarkRepository;

    public void handleMessage(ScrapingResultMessage scrapingResultMessage)
    {
        System.out.println("Received title: " + scrapingResultMessage.getTitle());
        final String url = scrapingResultMessage.getUrl();
        final List<Bookmark> bookmarks = bookmarkRepository.findByUrl(url);
        if (bookmarks.size() == 0)
        {
            System.out.println("No bookmark of url: " + url + " found.");
        }
        else
        {
            for (Bookmark bookmark : bookmarks)
            {
                bookmark.setTitle(scrapingResultMessage.getTitle());
                bookmarkRepository.save(bookmarks);
                System.out.println("updated bookmark: " + url);
            }
        }
    }
}
