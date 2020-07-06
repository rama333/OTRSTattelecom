package com.example.otrstattelecom.model.dto;

import java.io.Serializable;

public class Article implements Serializable {

    String ContentType;
    String  SenderTypeID;
    String  ReplyTo;
    String  References;
    String  ContentCharset;
    String  SenderType;
    String  CreateBy;
    String  TicketID;
    String  Body;
    String  ChangeBy;
    String  ChangeTime;
    String  MimeType;
    String  Cc;
    String  Subject;
    String  IsVisibleForCustomer;
    String  CreateTime;
    String  InReplyTo;
    String  IncomingTime;
    String  TimeUnit;
    String  Charset;
    String  CommunicationChannelID;
    String  Bcc;
    String  MessageID;
    String  ArticleNumber;
    String  ArticleID;
    String  To;
    String  From;

    public Article(String contentType, String senderTypeID, String replyTo, String references, String contentCharset, String senderType, String createBy, String ticketID, String body, String changeBy, String changeTime, String mimeType, String cc, String subject, String isVisibleForCustomer, String createTime, String inReplyTo, String incomingTime, String timeUnit, String charset, String communicationChannelID, String bcc, String messageID, String articleNumber, String articleID, String to, String from) {
        ContentType = contentType;
        SenderTypeID = senderTypeID;
        ReplyTo = replyTo;
        References = references;
        ContentCharset = contentCharset;
        SenderType = senderType;
        CreateBy = createBy;
        TicketID = ticketID;
        Body = body;
        ChangeBy = changeBy;
        ChangeTime = changeTime;
        MimeType = mimeType;
        Cc = cc;
        Subject = subject;
        IsVisibleForCustomer = isVisibleForCustomer;
        CreateTime = createTime;
        InReplyTo = inReplyTo;
        IncomingTime = incomingTime;
        TimeUnit = timeUnit;
        Charset = charset;
        CommunicationChannelID = communicationChannelID;
        Bcc = bcc;
        MessageID = messageID;
        ArticleNumber = articleNumber;
        ArticleID = articleID;
        To = to;
        From = from;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }

    public String getSenderTypeID() {
        return SenderTypeID;
    }

    public void setSenderTypeID(String senderTypeID) {
        SenderTypeID = senderTypeID;
    }

    public String getReplyTo() {
        return ReplyTo;
    }

    public void setReplyTo(String replyTo) {
        ReplyTo = replyTo;
    }

    public String getReferences() {
        return References;
    }

    public void setReferences(String references) {
        References = references;
    }

    public String getContentCharset() {
        return ContentCharset;
    }

    public void setContentCharset(String contentCharset) {
        ContentCharset = contentCharset;
    }

    public String getSenderType() {
        return SenderType;
    }

    public void setSenderType(String senderType) {
        SenderType = senderType;
    }

    public String getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(String createBy) {
        CreateBy = createBy;
    }

    public String getTicketID() {
        return TicketID;
    }

    public void setTicketID(String ticketID) {
        TicketID = ticketID;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getChangeBy() {
        return ChangeBy;
    }

    public void setChangeBy(String changeBy) {
        ChangeBy = changeBy;
    }

    public String getChangeTime() {
        return ChangeTime;
    }

    public void setChangeTime(String changeTime) {
        ChangeTime = changeTime;
    }

    public String getMimeType() {
        return MimeType;
    }

    public void setMimeType(String mimeType) {
        MimeType = mimeType;
    }

    public String getCc() {
        return Cc;
    }

    public void setCc(String cc) {
        Cc = cc;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getIsVisibleForCustomer() {
        return IsVisibleForCustomer;
    }

    public void setIsVisibleForCustomer(String isVisibleForCustomer) {
        IsVisibleForCustomer = isVisibleForCustomer;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getInReplyTo() {
        return InReplyTo;
    }

    public void setInReplyTo(String inReplyTo) {
        InReplyTo = inReplyTo;
    }

    public String getIncomingTime() {
        return IncomingTime;
    }

    public void setIncomingTime(String incomingTime) {
        IncomingTime = incomingTime;
    }

    public String getTimeUnit() {
        return TimeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        TimeUnit = timeUnit;
    }

    public String getCharset() {
        return Charset;
    }

    public void setCharset(String charset) {
        Charset = charset;
    }

    public String getCommunicationChannelID() {
        return CommunicationChannelID;
    }

    public void setCommunicationChannelID(String communicationChannelID) {
        CommunicationChannelID = communicationChannelID;
    }

    public String getBcc() {
        return Bcc;
    }

    public void setBcc(String bcc) {
        Bcc = bcc;
    }

    public String getMessageID() {
        return MessageID;
    }

    public void setMessageID(String messageID) {
        MessageID = messageID;
    }

    public String getArticleNumber() {
        return ArticleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        ArticleNumber = articleNumber;
    }

    public String getArticleID() {
        return ArticleID;
    }

    public void setArticleID(String articleID) {
        ArticleID = articleID;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }
}
