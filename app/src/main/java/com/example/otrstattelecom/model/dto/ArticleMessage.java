package com.example.otrstattelecom.model.dto;

public class ArticleMessage {
    String Body;
    String Charset;
    String Subject;
    String MimeType;
    String TimeUnit;


    public ArticleMessage(String body, String charset, String subject, String mimeType, String timeUnit) {
        Body = body;
        Charset = charset;
        Subject = subject;
        MimeType = mimeType;
        TimeUnit = timeUnit;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getCharset() {
        return Charset;
    }

    public void setCharset(String charset) {
        Charset = charset;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getMimeType() {
        return MimeType;
    }

    public void setMimeType(String mimeType) {
        MimeType = mimeType;
    }

    public String getTimeUnit() {
        return TimeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        TimeUnit = timeUnit;
    }
}