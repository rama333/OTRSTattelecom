package com.example.otrstattelecom.model.dto;

public class History {


    String PriorityID;
    String CreateTime;
    String OwnerID;
    String QueueID;
    String HistoryType;
    String TypeID ;
    String HistoryTypeID;
    String ArticleID ;
    String StateID ;
    String CreateBy;
    String TicketID;
    String Name;

    public History(String priorityID, String createTime, String ownerID, String queueID, String historyType, String typeID, String historyTypeID, String articleID, String stateID, String createBy, String ticketID, String name) {
        PriorityID = priorityID;
        CreateTime = createTime;
        OwnerID = ownerID;
        QueueID = queueID;
        HistoryType = historyType;
        TypeID = typeID;
        HistoryTypeID = historyTypeID;
        ArticleID = articleID;
        StateID = stateID;
        CreateBy = createBy;
        TicketID = ticketID;
        Name = name;
    }


    public String getPriorityID() {
        return PriorityID;
    }

    public void setPriorityID(String priorityID) {
        PriorityID = priorityID;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(String ownerID) {
        OwnerID = ownerID;
    }

    public String getQueueID() {
        return QueueID;
    }

    public void setQueueID(String queueID) {
        QueueID = queueID;
    }

    public String getHistoryType() {
        return HistoryType;
    }

    public void setHistoryType(String historyType) {
        HistoryType = historyType;
    }

    public String getTypeID() {
        return TypeID;
    }

    public void setTypeID(String typeID) {
        TypeID = typeID;
    }

    public String getHistoryTypeID() {
        return HistoryTypeID;
    }

    public void setHistoryTypeID(String historyTypeID) {
        HistoryTypeID = historyTypeID;
    }

    public String getArticleID() {
        return ArticleID;
    }

    public void setArticleID(String articleID) {
        ArticleID = articleID;
    }

    public String getStateID() {
        return StateID;
    }

    public void setStateID(String stateID) {
        StateID = stateID;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
