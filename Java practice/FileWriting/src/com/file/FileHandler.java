package com.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandler {

    public void create(){
        System.out.println("Enter filename with extension to be created: ");
        Scanner in=new Scanner(System.in);
        String filename=in.nextLine();
        File file=new File(filename);
        try {
            if(file.createNewFile()){
                System.out.println("File created successfully with filename of "+filename);
            }
        } catch (Exception e) {
            System.out.println("Error occurred in creating file");
        }
    }
    public void read(){

        System.out.println("Enter file path: ");
        Scanner in=new Scanner(System.in);
        String path=in.nextLine();
        File file=new File(path);
        try {
            Scanner read=new Scanner(file);
            while (read.hasNextLine()){
                System.out.println(read.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    public void delete(){

        System.out.println("Enter file path: ");
        Scanner in=new Scanner(System.in);
        String path=in.nextLine();
        File file=new File(path);
        try{
            if(file.delete()) System.out.println("File at path "+path+" deleted successfully.");
            else System.out.println("Failed to delete");
        }catch (Exception e){
            System.out.println("File not found.");
        }



    }

    public void write() {
        System.out.println("Enter file path: ");
        Scanner in=new Scanner(System.in);
        String path=in.nextLine();
        File file=new File(path);


        System.out.println("Enter content being written in file: ");
        String content = in.nextLine();

        try {
            FileWriter obj = new FileWriter(file);
            obj.write(content);

            System.out.println("File being written successfully");

            obj.close();
        } catch (Exception e) {
            System.out.println("File not found.");
        }

    }
}
