package com.example.otrstattelecom.model.response;

public class Message {

    String ArticleID;
    String TicketNumber;
    String TicketID;


    public Message(String articleID, String ticketNumber, String ticketID) {
        ArticleID = articleID;
        TicketNumber = ticketNumber;
        TicketID = ticketID;
    }

    public String getArticleID() {
        return ArticleID;
    }

    public void setArticleID(String articleID) {
        ArticleID = articleID;
    }

    public String getTicketNumber() {
        return TicketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        TicketNumber = ticketNumber;
    }

    public String getTicketID() {
        return TicketID;
    }

    public void setTicketID(String ticketID) {
        TicketID = ticketID;
    }
}
