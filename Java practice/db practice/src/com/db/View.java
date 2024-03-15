package com.db;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private Controller controller=new Controller(null);
    public void displayMail(Mail obj){
        System.out.println("ID: " + obj.getId());
        System.out.println("Sender: " + obj.getSender());
        System.out.println("reciever: " + obj.getReciever());
        System.out.println("subject: " + obj.getSubject());
        System.out.println("message: " + obj.getMessage());
        System.out.println("date: " + obj.getDate());
        System.out.println("read: " + obj.isRead());
        System.out.println("starred: " + obj.isStarred());
        System.out.println("type: " + obj.getType());

        System.out.println("-----------------------------------------------------------------------");

    }

    public void displayUsers(Users user){
        System.out.println("User id: "+user.getUser_id());
        System.out.println("User name: "+user.getUser_name());
        System.out.println("Mail id: "+user.getMail_id());
        System.out.println("-----------------------------------------------------------------------");

    }



    public void display(int id, String sender, String reciever, String subject, String message, String date, boolean read, boolean starred, String type) {
        System.out.println("ID: " + id);
        System.out.println("Sender: " + sender);
        System.out.println("reciever: " + reciever);
        System.out.println("subject: " + subject);
        System.out.println("message: " + message);
        System.out.println("date: " + date);
        System.out.println("read: " + read);
        System.out.println("starred: " + starred);
        System.out.println("type: " + type);

        System.out.println("-----------------------------------------------------------------------");

    }

    public void connect(){
        Scanner in=new Scanner(System.in);
        boolean isConnect=controller.connectToDB("employee_record","postgres","Maha@2021");
        if(isConnect){
            System.out.println("connection established");
        }else System.out.println("failed to connect.");

        System.out.println("Enter table name to perform operations: ");
        String tablename=in.next();

        int choice =-1;
        while (choice!=0){
            System.out.println("1. view table\n2. create table \n3. insert row\n4. delete row\n5. delete table \n6. update table \n0. exit");
            choice=in.nextInt();
            switch (choice){
                case 1-> read_table(tablename);
                case 2-> create_table();
                case 3-> insert_row(tablename);
                case 4-> delete_row(tablename);
                case 5-> delete_table(tablename);
                case 6-> update_table(tablename);
                case 0-> System.out.println("exit");
                default -> System.out.println("Enter valid choice");
            }
        }

    }

    public void read_table(String tablename){
        System.out.println("Table is being readed.");
        System.out.println("\n");
        ArrayList list=controller.read_table(tablename);
        if (list.size()!=0){
            System.out.println("-----------------------------------------------------------------------");
            if (tablename.equals("mails")){
                for (Object mail:list){
                    displayMail((Mail) mail);
                }
            }
            else if (tablename.equals("users")){
                for (Object user:list){
                    displayUsers((Users) user);
                }
            }

        }
    }

    public void create_table(){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter table name: ");
        String tablename=in.next();
        boolean isTableCreated=controller.create_Table(tablename);
        if (isTableCreated){
            System.out.println("Table "+tablename+ " created successfully");
        }else System.out.println("Failed to create table");

    }

    public void delete_row(String tablename){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter id: ");
        int id=in.nextInt();
        boolean isRowDeleted= controller.delete_row(tablename,id);
        if (isRowDeleted){
            System.out.println("row with id "+id+ " deleted successfully");
        }
        else{
            System.out.println("Failed to delete row with id "+id);

        }
    }

   public Mail mailEntryInfo(){
       Scanner in=new Scanner(System.in);
       Scanner inStr=new Scanner(System.in);
       System.out.println("Enter sender userID: ");
       String sender=in.nextInt()+"";
       System.out.println("Enter reciever userID: ");
       String reciever=in.nextInt()+"";
       System.out.println("Enter subject: ");
       String subject=inStr.nextLine();
       System.out.println("Enter message: ");
       String message=inStr.nextLine();
       System.out.println("Type : \n 1. send \n 2.reciever");
       int choice=in.nextInt();
       String type="sender";
       switch (choice){
           case (1)->type="sender";
           case (2)->type="reciever";
           default -> System.out.println("option invalid");
       }
       boolean read;
       boolean starred;

       read=false;
       starred=false;

       Mail mailObj=new Mail(sender,reciever,subject,message,read,starred,type);
       return mailObj;
   }

   public Users userInfo(){
        Scanner in=new Scanner(System.in);
       System.out.println("Enter user name: ");
        String user_name=in.nextLine();
       System.out.println("Enter mail id: ");
       String mail_id=in.nextLine();
       Users user=new Users(user_name,mail_id);
       return user;
   }

    public void insert_row(String tablename){
        Object obj=(tablename.equals("users")) ? userInfo() : mailEntryInfo();

        boolean isInserted=controller.insert_row(tablename,obj);
        if (isInserted){
            System.out.println("row Inserted successfully");
        }
        else{
            System.out.println("Failed to insert row.");
        }
    }

    public void delete_table(String tablename){
        boolean isDeleted=controller.delete_table(tablename);
        if (isDeleted){
            System.out.println("table "+tablename+" deleted successfully.");

        }else {
            System.out.println("Failed to delete table.");
        }

    }

    public void update_table(String tablename){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter column name: ");
        String column=in.nextLine();
        System.out.println("Enter value: ");
        int value=in.nextInt();
        System.out.println("Enter condition column: ");
        String condition_column=in.next();
        System.out.println("Enter where to change: ");
        String where_to_change=in.next();
        boolean isUpdated=controller.update_table(tablename,column,value,condition_column,where_to_change);
        if (isUpdated){
            System.out.println("table "+tablename+" updated successfully.");

        }else  System.out.println("Failed to update table.");

    }
}
