package com.db;

public class Mail {

    private int id;
    private String sender;
    private String reciever;
    private String subject;
    private String message;
    private String date;
    private boolean read;
    private boolean starred;
    private String type;

    public Mail(int id, String sender, String reciever, String subject, String message, String date, boolean read, boolean starred, String type) {
        this.id = id;
        this.sender = sender;
        this.reciever = reciever;
        this.subject = subject;
        this.message = message;
        this.date = date;
        this.read = read;
        this.starred = starred;
        this.type = type;
    }

    public Mail(String sender, String reciever, String subject, String message, boolean read, boolean starred, String type) {
        this.sender = sender;
        this.reciever = reciever;
        this.subject = subject;
        this.message = message;
        this.read = read;
        this.starred = starred;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public boolean isRead() {
        return read;
    }

    public boolean isStarred() {
        return starred;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "MailModel{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", receiver='" + reciever + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                ", read=" + read +
                ", starred=" + starred +
                ", type='" + type + '\'' +
                '}';
    }
}
