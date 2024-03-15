package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;



public class Controller {
    private Connection connection;

    private DbConnection db=new DbConnection();

    public Controller(Connection connection) {
        this.connection = connection;


    }

    public boolean connectToDB(String dbname,String user,String password){
        Connection con=null;
        try{
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,password);
            this.connection=con;
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

    public ArrayList read_table(String tablename){
        return db.read_table(connection,tablename);
    }

    public void read_table_without_obj(String tablename){
        System.out.println("----------------------------------------------------------------");
        db.read_table_without_obj(connection,tablename);

    }
    public boolean create_Table(String tablename){

        return db.create_table(connection,tablename);
    }

    public boolean delete_row(String tablename,int Id){

        return db.delete_row(connection,tablename,Id);
    }
    public boolean delete_table(String tablename){

        return db.delete_table(connection,tablename);
    }
    public boolean insert_row(String tablename,Object obj){
        return db.insert_rows(connection,tablename,obj);
    }


    public boolean update_table(String tablename,String column_name,int value,String condition_column_name,String where_to_change) {
        return db.update_table(connection,tablename,column_name,value,condition_column_name,where_to_change);
    }
}
