package backend.api.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import backend.api.amqp.TaskMessage;
import backend.api.amqp.TaskProducer;

import java.util.Date;

@RepositoryEventHandler(Bookmark.class)
public class BookmarkEventHandler
{
    @Autowired
    private TaskProducer taskProducer;

    @HandleBeforeCreate
    public void handleBookmarkCreate(Bookmark bookmark)
    {
        bookmark.setCreated(new Date());
        bookmark.setUrl(bookmark.getUrl().trim());

    }

    @HandleAfterCreate
    public void handleAfterBookmarkCreate(Bookmark bookmark)
    {
        final TaskMessage taskMessage = new TaskMessage();
        taskMessage.setUrl(bookmark.getUrl());
        taskProducer.sendNewTask(taskMessage);
    }

}
