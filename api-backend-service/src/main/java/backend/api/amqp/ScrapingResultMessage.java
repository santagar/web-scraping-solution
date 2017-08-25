package backend.api.amqp;

public class ScrapingResultMessage
{
    private String url;
    private String title;
    private String codeSnippets;

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCodeSnippets()
    {
        return codeSnippets;
    }

    public void setCodeSnippets(String codeSnippets)
    {
        this.codeSnippets = codeSnippets;
    }
}
