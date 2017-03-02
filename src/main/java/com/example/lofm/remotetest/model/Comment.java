package com.example.lofm.remotetest.model;

/**
 * Created by LOFM on 02/03/2017.
 */

public class Comment {

    private static Comment commentInstance = null;
    private int commentId;
    private String commentText;

    private Comment(String commentText) {
        this.commentText = commentText;
        this.commentId = autoGenerateId();
    }

    private int autoGenerateId() {
        //Auto generate ID for each new comment
        return 0;
    }

    public static Comment getInstance(String commentText) {
        if (commentInstance == null) {
            commentInstance = new Comment(commentText);
        } else {
            if (!commentInstance.getCommentText().equalsIgnoreCase(commentText)) {
                commentInstance = new Comment(commentText);
            }
        }
        return commentInstance;
    }

    private String getCommentText() {
        return commentText;
    }

}
