package com.mail;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


        Scanner in =new Scanner(System.in);
        Operations op = new Operations();
       int choice=-1;


        while (choice!=0) {
            System.out.println("1.GET\n");
            System.out.println("2.POST\n");
            System.out.println("3.SENT MAILS\n");
            System.out.println("4.Inbox MAILS\n");
            System.out.println("5.Readed MAILS\n");
            System.out.println("6.Starred MAILS\n");
            System.out.println("7.DELETE MAIL\n");
            System.out.println("0.EXIT\n");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    op.getData("src/file.json");
                    break;
                case 2:
                    try {
                        op.postData();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    op.displaySentMails();
                    break;
                case 4:
                    op.displayInboxMails();
                    break;
                case 5:
                    op.displayReadedMails();
                    break;
                case 6:
                    op.displayStarredMails();
                    break;
                case 7:
                    op.deleteMail();
                    break;

            }
        }
    }
}