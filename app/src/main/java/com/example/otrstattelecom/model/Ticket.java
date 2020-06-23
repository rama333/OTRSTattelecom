package com.example.otrstattelecom.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Ticket implements Serializable {
    String Age;
    String PriorityID;
    String ServiceID;
    String Service;
    String Type;
    String Responsible;
    String StateID;
    String ResponsibleID;
    String ChangeBy;
    String EscalationTime;
    String OwnerID;
    String Changed;
    String TimeUnit;
    String RealTillTimeNotUsed;
    String GroupID;
    String Owner;
    String CustomerID;
    String TypeID;
    String Created;
    String Priority;
    String UntilTime;
    String EscalationUpdateTime;
    String Queue;
    String QueueID;
    String State;
    String Title;
    String CreateBy;
    String TicketID;
    String StateType;
    String UnlockTimeout;
    String EscalationResponseTime;
    String EscalationSolutionTime;
    String LockID;
    String TicketNumber;
    String ArchiveFlag;
    String Lock;
    String SLAID;
    String CustomerUserID;
    @SerializedName("Article")
    List<Article> articleList;

    public Ticket(String age, String priorityID, String serviceID, String service, String type, String responsible, String stateID, String responsibleID, String changeBy, String escalationTime, String ownerID, String changed, String timeUnit, String realTillTimeNotUsed, String groupID, String owner, String customerID, String typeID, String created, String priority, String untilTime, String escalationUpdateTime, String queue, String queueID, String state, String title, String createBy, String ticketID, String stateType, String unlockTimeout, String escalationResponseTime, String escalationSolutionTime, String lockID, String ticketNumber, String archiveFlag, String lock, String SLAID, String customerUserID, List<Article> articleList) {
        Age = age;
        PriorityID = priorityID;
        ServiceID = serviceID;
        Service = service;
        Type = type;
        Responsible = responsible;
        StateID = stateID;
        ResponsibleID = responsibleID;
        ChangeBy = changeBy;
        EscalationTime = escalationTime;
        OwnerID = ownerID;
        Changed = changed;
        TimeUnit = timeUnit;
        RealTillTimeNotUsed = realTillTimeNotUsed;
        GroupID = groupID;
        Owner = owner;
        CustomerID = customerID;
        TypeID = typeID;
        Created = created;
        Priority = priority;
        UntilTime = untilTime;
        EscalationUpdateTime = escalationUpdateTime;
        Queue = queue;
        QueueID = queueID;
        State = state;
        Title = title;
        CreateBy = createBy;
        TicketID = ticketID;
        StateType = stateType;
        UnlockTimeout = unlockTimeout;
        EscalationResponseTime = escalationResponseTime;
        EscalationSolutionTime = escalationSolutionTime;
        LockID = lockID;
        TicketNumber = ticketNumber;
        ArchiveFlag = archiveFlag;
        Lock = lock;
        this.SLAID = SLAID;
        CustomerUserID = customerUserID;
        this.articleList = articleList;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getPriorityID() {
        return PriorityID;
    }

    public void setPriorityID(String priorityID) {
        PriorityID = priorityID;
    }

    public String getServiceID() {
        return ServiceID;
    }

    public void setServiceID(String serviceID) {
        ServiceID = serviceID;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getResponsible() {
        return Responsible;
    }

    public void setResponsible(String responsible) {
        Responsible = responsible;
    }

    public String getStateID() {
        return StateID;
    }

    public void setStateID(String stateID) {
        StateID = stateID;
    }

    public String getResponsibleID() {
        return ResponsibleID;
    }

    public void setResponsibleID(String responsibleID) {
        ResponsibleID = responsibleID;
    }

    public String getChangeBy() {
        return ChangeBy;
    }

    public void setChangeBy(String changeBy) {
        ChangeBy = changeBy;
    }

    public String getEscalationTime() {
        return EscalationTime;
    }

    public void setEscalationTime(String escalationTime) {
        EscalationTime = escalationTime;
    }

    public String getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(String ownerID) {
        OwnerID = ownerID;
    }

    public String getChanged() {
        return Changed;
    }

    public void setChanged(String changed) {
        Changed = changed;
    }

    public String getTimeUnit() {
        return TimeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        TimeUnit = timeUnit;
    }

    public String getRealTillTimeNotUsed() {
        return RealTillTimeNotUsed;
    }

    public void setRealTillTimeNotUsed(String realTillTimeNotUsed) {
        RealTillTimeNotUsed = realTillTimeNotUsed;
    }

    public String getGroupID() {
        return GroupID;
    }

    public void setGroupID(String groupID) {
        GroupID = groupID;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getTypeID() {
        return TypeID;
    }

    public void setTypeID(String typeID) {
        TypeID = typeID;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String created) {
        Created = created;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public String getUntilTime() {
        return UntilTime;
    }

    public void setUntilTime(String untilTime) {
        UntilTime = untilTime;
    }

    public String getEscalationUpdateTime() {
        return EscalationUpdateTime;
    }

    public void setEscalationUpdateTime(String escalationUpdateTime) {
        EscalationUpdateTime = escalationUpdateTime;
    }

    public String getQueue() {
        return Queue;
    }

    public void setQueue(String queue) {
        Queue = queue;
    }

    public String getQueueID() {
        return QueueID;
    }

    public void setQueueID(String queueID) {
        QueueID = queueID;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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

    public String getStateType() {
        return StateType;
    }

    public void setStateType(String stateType) {
        StateType = stateType;
    }

    public String getUnlockTimeout() {
        return UnlockTimeout;
    }

    public void setUnlockTimeout(String unlockTimeout) {
        UnlockTimeout = unlockTimeout;
    }

    public String getEscalationResponseTime() {
        return EscalationResponseTime;
    }

    public void setEscalationResponseTime(String escalationResponseTime) {
        EscalationResponseTime = escalationResponseTime;
    }

    public String getEscalationSolutionTime() {
        return EscalationSolutionTime;
    }

    public void setEscalationSolutionTime(String escalationSolutionTime) {
        EscalationSolutionTime = escalationSolutionTime;
    }

    public String getLockID() {
        return LockID;
    }

    public void setLockID(String lockID) {
        LockID = lockID;
    }

    public String getTicketNumber() {
        return TicketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        TicketNumber = ticketNumber;
    }

    public String getArchiveFlag() {
        return ArchiveFlag;
    }

    public void setArchiveFlag(String archiveFlag) {
        ArchiveFlag = archiveFlag;
    }

    public String getLock() {
        return Lock;
    }

    public void setLock(String lock) {
        Lock = lock;
    }

    public String getSLAID() {
        return SLAID;
    }

    public void setSLAID(String SLAID) {
        this.SLAID = SLAID;
    }

    public String getCustomerUserID() {
        return CustomerUserID;
    }

    public void setCustomerUserID(String customerUserID) {
        CustomerUserID = customerUserID;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
