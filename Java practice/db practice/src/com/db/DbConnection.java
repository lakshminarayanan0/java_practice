package com.db;

import java.sql.*;
import java.util.ArrayList;

public class DbConnection {

    public ArrayList read_table(Connection con,String tablename){
        Statement st=null;
        ResultSet rs=null;
        ArrayList arr=new ArrayList<>();

        try{


            if (tablename.equals("users")){
                String query=String.format("select * from %s;",tablename);
                st=con.createStatement();
                rs=st.executeQuery(query);

                while (rs.next()){
                    int user_id=rs.getInt("user_id");
                    String user_name=rs.getString("users");
                    String mail_id=rs.getString("mail_id");
                    arr.add(new Users(user_id,user_name,mail_id));
                }
            }
            else if (tablename.equals("mails")) {
                String query = String.format(
                        "SELECT " +
                                "    m.id," +
                                "    u_sender.users AS sender_name," +
                                "    u_reciever.users AS reciever_name," +
                                "    m.subject," +
                                "    m.message," +
                                "    m.date," +
                                "    m.read," +
                                "    m.starred," +
                                "    m.type " +
                                "FROM " +
                                "    mails m " +
                                "INNER JOIN " +
                                "    users u_sender ON m.sender = u_sender.user_id " +
                                "INNER JOIN " +
                                "    users u_reciever ON m.reciever = u_reciever.user_id;"
                );

                st=con.createStatement();
                rs=st.executeQuery(query);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String sender = rs.getString("sender_name");
                    String reciever = rs.getString("reciever_name");
                    String subject = rs.getString("subject");
                    String message = rs.getString("message");
                    String date = rs.getString("date");
                    boolean read = rs.getBoolean("read");
                    boolean starred = rs.getBoolean("starred");
                    String type = rs.getString("type");

                    arr.add(new Mail(id,sender,reciever,subject,message,date,read,starred,type));

                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            if (st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return arr;
    }

    public void read_table_without_obj(Connection con,String tablename){
        Statement st;
        ResultSet rs=null;


        try{
            String query=String.format("select * from %s;",tablename);
            st=con.createStatement();
            rs=st.executeQuery(query);
            System.out.println("Table is being readed.");
            System.out.println("\n");
            while (rs.next()) {
                int id = rs.getInt("id");
                String sender = rs.getString("sender");
                String reciever = rs.getString("reciever");
                String subject = rs.getString("subject");
                String message = rs.getString("message");
                String date = rs.getString("date");
                boolean read = rs.getBoolean("read");
                boolean starred = rs.getBoolean("starred");
                String type = rs.getString("type");
                View view=new View();
                view.display(id,sender,reciever,subject,message,date,read,starred,type);

            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public boolean create_table(Connection con,String tablename) {

        Statement st;
       try{
           String query=String.format("create table %s (user_id serial primary key,%s varchar(100),%s varchar(256));",tablename,"users","mail_id");
           st=con.createStatement();
           st.executeUpdate(query);
           return true;

       }catch (Exception e){
           System.out.println(e);
           return false;
       }


    }
    public boolean delete_table(Connection con,String tablename){
        Statement st;
        try{
            String query=String.format("drop table %s;",tablename);
            st=con.createStatement();
            st.executeUpdate(query);
            return true;

        }catch (Exception e){
            return false;
        }

    }

    public boolean insert_rows(Connection con, String tablename, Object object) {
        Statement st = null;

        try {
            if (object instanceof Mail) {
                Mail obj = (Mail) object;
                String query = "INSERT INTO " + tablename + " (sender, reciever, subject, message, read, starred, type) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, Integer.parseInt(obj.getSender()));
                preparedStatement.setInt(2, Integer.parseInt(obj.getReciever()));
                preparedStatement.setString(3, obj.getSubject());
                preparedStatement.setString(4, obj.getMessage());
                preparedStatement.setBoolean(5, obj.isRead());
                preparedStatement.setBoolean(6, obj.isStarred());
                preparedStatement.setString(7, obj.getType());

                preparedStatement.executeUpdate();
            } else if (object instanceof Users) {
                Users obj = (Users) object;
                String query ="insert into "+ tablename+" (users,mail_id) values (?,?);";
                PreparedStatement preparedStatement=con.prepareStatement(query);
                preparedStatement.setString(1,obj.getUser_name());
                preparedStatement.setString(2,obj.getMail_id());
                preparedStatement.executeUpdate();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public boolean delete_row(Connection con, String tablename, int id) {
        Statement st;
        try
        {
            String query=String.format("DELETE FROM %s WHERE id = %d",tablename,id);
            st=con.createStatement();
            st.executeUpdate(query);
            return true;

        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean update_table(Connection connection, String tablename,String column_name,int value,String condition_column_name,String where_to_change) {
        Statement st=null;

        try{
            String query=String.format("update %s set %s=%d where %s='%s'",tablename,column_name,value,condition_column_name,where_to_change);
            st=connection.createStatement();
            st.executeUpdate(query);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
