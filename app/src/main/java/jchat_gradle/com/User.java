package jchat_gradle.com;

import java.util.ArrayList;

public class User {
    private String userID;
    private String Address;
    private String Name;


    private ArrayList<Message> inboxMessages = new ArrayList<Message>();
    private ArrayList<Message> outboxMessages = new ArrayList<Message>();

    public User(String userID, String address, String name) {
        setUserID(userID);
        setAddress(address);
        setName(name);
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Message getInboxMessage(int index) {
        return inboxMessages.get(index);
    }

    public Integer getNumInboxMessages() {
        return inboxMessages.size();
    }

    public void addInboxMessage(Message inboxMessages) {
        this.inboxMessages.add(inboxMessages);
    }

    public Message getOutboxMessage(int index) {
        return outboxMessages.get(index);
    }

    public Integer getNumOutboxMessages() {
        return outboxMessages.size();
    }

    public void addOutboxMessage(Message outboxMessages) {
        this.outboxMessages.add(outboxMessages);
    }

    public String toString() {
        String output = String.format("UserID: %s\nUser Address: %s\nUser Name: %s\nInbox Messages: %d\nOutbox Messages: %d",
                                        this.getUserID(), this.getAddress(), this.getName(), this.getNumInboxMessages(), this.getNumOutboxMessages());
        return output;
    }
}
