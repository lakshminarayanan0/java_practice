
import com.file.FileHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        System.out.println("Hello guys this program is to practice file handling...");
        Scanner in =new Scanner(System.in);
        int choice=0;
        FileHandler fh = new FileHandler();
        while (choice!=5) {
            System.out.println("\n1.create file\n2.read file\n3.write file\n4.delete file\n5.exit");
            System.out.println("Please enter your choice by entering corresponding numbers.");

            choice=in.nextInt();

            switch (choice) {
                case 1: {
                    fh.create();
                    break;
                }
                case 2: {
                    fh.read();
                    break;
                }
                case 3: {
                    fh.write();
                    break;
                }
                case 4: {
                    fh.delete();
                    break;
                }
            }
        }
    }
}