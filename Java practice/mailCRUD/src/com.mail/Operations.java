package com.mail;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;



public class Operations {


    public void getData(String filePath) {
        MailObject obj = new MailObject();
        File file = new File(filePath);

        try {
            String data = obj.getData(file);

            JSONParser parser = new JSONParser();
            Object object = parser.parse(data);


            if (object instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) object;


                for (Object item : jsonArray) {

                    JSONObject jsonObject = (JSONObject) item;
                    long id=(long) jsonObject.get("id");
                    String user = (String) jsonObject.get("sender");
                    String reciever = (String) jsonObject.get("reciever");
                    String subject = (String) jsonObject.get("subject");
                    String message = (String) jsonObject.get("message");
                    String date = (String) jsonObject.get("date");
                    boolean read = (boolean) jsonObject.get("read");
                    boolean starred = (boolean) jsonObject.get("starred");
                    String type = (String) jsonObject.get("type");


                    MailObject mailObj = new MailObject(id, user, reciever, subject, message, date, read, starred, type);
                    System.out.println(mailObj.toString());
                }
            } else {
                throw new RuntimeException("Invalid JSON format. Expected an array.");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void postData() throws Exception {
        System.out.println("Here we go! ... Type your mail to post :(");
        Map<String,MailObject> mailList=get("src/file.json");
        System.out.println(mailList);

        Scanner in = new Scanner(System.in);

        System.out.println("Enter your email: ");
        String user = in.nextLine();
        System.out.println("Enter reciever to send mail: ");
        String reciever = in.nextLine();
        System.out.println("Enter subject of mail: ");
        String subject = in.nextLine();
        System.out.println("Compose your mail here: ");
        String message = in.nextLine();
        String type = "sender";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        long newId = Instant.now().toEpochMilli();
        MailObject mailObject = new MailObject(newId, user, reciever, subject, message, date, false, false, type);
//        mailList.put(user+date,mailObject);

//        try {
//            FileWriter fileWriter=new FileWriter("src/file.json",false);
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            String jsonString = gson.toJson(mailList.values());
//            fileWriter.write(jsonString);
//            System.out.println("Data has been appended to file.json");
//
//        }
        try (FileWriter fileWriter = new FileWriter("src/file.json", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString = gson.toJson(mailList);

            // Append a comma and the new JSON object (if not the first object)
            if (Files.size(Paths.get("src/file.json")) > 0) {
                printWriter.print(",");
            }

            printWriter.print(jsonString);
            printWriter.println("]");

            System.out.println("Data has been appended to file.json");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Map<String, MailObject> get(String s) throws Exception {
        MailObject obj = new MailObject();
        File file = new File(s);
        Map<String, MailObject> mailList = new LinkedHashMap<>();

        try {
            String data = obj.getData(file);

            JSONParser parser = new JSONParser();
            Object object = parser.parse(data);


            if (object instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) object;
                int mailCount = 0;
                for (Object item : jsonArray) {
                    ++mailCount;
                    JSONObject jsonObject = (JSONObject) item;
                    long id=(long) jsonObject.get("id");
                    String user = (String) jsonObject.get("sender");
                    String reciever = (String) jsonObject.get("reciever");
                    String subject = (String) jsonObject.get("subject");
                    String message = (String) jsonObject.get("message");
                    String date = (String) jsonObject.get("date");
                    boolean read = (boolean) jsonObject.get("read");
                    boolean starred = (boolean) jsonObject.get("starred");
                    String type = (String) jsonObject.get("type");
                    mailList.put(user + date, new MailObject(id,user, reciever, subject, message, date, read, starred, type));
                }
                return mailList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new LinkedHashMap<>(){};
    }


    public void displaySentMails() throws Exception {
    Map<String,MailObject> mailList=get("src/file.json");
    boolean sentMails=false;
        if(mailList.size()>0){
            for (MailObject mail : mailList.values()) {
                if ("sender".equals(mail.getType())) {
                    System.out.println(mail.toString());
                    sentMails=true;
                }
            }
            if (!sentMails){
                System.out.println("No sent mails.");
            }
        }
        else System.out.println("No records found.");


    }

    public void displayInboxMails() throws Exception {
        Map<String,MailObject> mailList=get("src/file.json");
        boolean inboxMails=false;
        if(mailList.size()>0){
            for (MailObject mail : mailList.values()) {
                if ("reciever".equals(mail.getType())) {
                    System.out.println(mail.toString());
                    inboxMails=true;
                }
            }

            if(!inboxMails){
                System.out.println("No Inbox mails.");
            }
    }
        else System.out.println("No records found.");

    }

    public void displayReadedMails() throws Exception {
        Map<String,MailObject> mailList=get("src/file.json");
        boolean readedMails=false;
        if(mailList.size()>0){
            for (MailObject mail : mailList.values()) {
                if (mail.getRead()) {
                    readedMails=true;
                    System.out.println(mail.toString());
                }
            }
            if(!readedMails){
                System.out.println("No readed mails.");
            }
        }
        else System.out.println("No records found.");

    }

    public void displayStarredMails() throws Exception {
        Map<String,MailObject> mailList=get("src/file.json");
        boolean starredMails=false;

        if(mailList.size()>0){
            for (MailObject mail : mailList.values()) {
                if (mail.starred()) {
                    starredMails=true;
                    System.out.println(mail.toString());
                }
            }
            if (!starredMails){
                System.out.println("No starred mails.");
            }
        }
        else System.out.println("No records found.");


    }

    public void deleteMail() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Mail number : ");
        long id = in.nextLong();

        Map<String,MailObject> mailList=get("src/file.json");

        Iterator<Map.Entry<String, MailObject>> iterator = mailList.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, MailObject> entry = iterator.next();
            MailObject mail = entry.getValue();

            if (id == mail.getId()) {
                iterator.remove();
                try (
                        FileWriter fileWriter = new FileWriter("src/file.json")) {

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String jsonString = gson.toJson(mailList.values());
                    fileWriter.write(jsonString);
                    System.out.println("Id "+id+" Deleted successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return;
            }
        }

        System.out.println("Mail with ID " + id + " not found.");
    }

}
