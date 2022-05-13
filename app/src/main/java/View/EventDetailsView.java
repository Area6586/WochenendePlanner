package View;

import Controller.Comment;

public class EventDetailsView {
    Comment[] comments;

    public Boolean send(){

        return true;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
}
