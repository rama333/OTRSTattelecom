package com.example.otrstattelecom.model.request;

import com.example.otrstattelecom.model.dto.ArticleMessage;

public class MessageModelRequest {
    String SessionID;
    String  TicketID;
    ArticleMessage Article;

    public MessageModelRequest(String sessionID, String ticketID, ArticleMessage article) {
        SessionID = sessionID;
        TicketID = ticketID;
        this.Article = article;
    }

    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
    }

    public String getTicketID() {
        return TicketID;
    }

    public void setTicketID(String ticketID) {
        TicketID = ticketID;
    }

    public ArticleMessage getArticle() {
        return Article;
    }

    public void setArticle(ArticleMessage article) {
        this.Article = article;
    }
}
