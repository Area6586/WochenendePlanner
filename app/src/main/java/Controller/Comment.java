package Controller;

import java.util.Date;

public class Comment {
    private String text;
    private String user;
    private Date timestamp;
    private String event;

    public Comment(String text, String user, Date timestamp, String event) {
        this.text = text;
        this.user = user;
        this.timestamp = timestamp;
        this.event = event;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}

