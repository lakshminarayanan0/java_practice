package com.mail;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Instant;

public class MailObject {

    private long id;

    public long getId() {
        return id;
    }

    private String sender;
    private String reciever;
    private String subject;
    private String message;
    private String date;
    private boolean read;
    private boolean starred;
    private String type;
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

    public boolean getRead() {
        return read;
    }

    public boolean starred() {
        return starred;
    }

    public String getType() {
        return type;
    }



    public MailObject(long id,String sender, String reciever, String subject, String message, String date, boolean read, boolean starred, String type) {

        this.id=id;
        this.sender = sender;
        this.reciever=reciever;
        this.subject = subject;
        this.message = message;
        this.date = date;
        this.read = read;
        this.starred = starred;
        this.type = type;
    }

  public MailObject(){

  }

    public String getData(File file) throws Exception{
        String data="";
        BufferedReader reader=new BufferedReader(new FileReader(file));

        String line;

        while ((line=reader.readLine())!=null){
            data+=line+" \n";
        }
        return data;
    }

    @Override
    public String toString() {
        return  "{"+'\n'+
                "mailNumber: " + id + ","+'\n' +
                "user: " + sender + ","+'\n' +
                "Reciever: " + reciever + ","+'\n' +
                "subject: " + subject+"," + '\n' +
                "message: " + message +","+ '\n' +
                "date: " + date +","+ '\n' +
                "read: " + read +","+" \n"+
                "starred: " + starred +","+" \n"+
                "type: " + type + '\n' +
                "}"
                ;
    }
}
