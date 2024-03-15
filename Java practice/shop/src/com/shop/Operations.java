package com.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Operations {
    private Connection connection;
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

    public ArrayList topPurchaseToday() {

        Statement st;
        ResultSet rs;
        ArrayList arr=new ArrayList<>();

        try{
            String query="select t.transaction_id , t.customer_id,c.first_name,c.last_name, t.total_amount \n" +
                    "from transactions t \n" +
                    "left join customers c on t.customer_id=c.customer_id\n" +
                    "where t.transaction_date=current_date-interval '1 day'\n" +
                    "order by t.total_amount desc" +
                    " limit 10;";
            st=connection.createStatement();
            rs=st.executeQuery(query);
            while (rs.next()){
                int transaction_id=rs.getInt("transaction_id");
                int customer_id=rs.getInt("customer_id");
                String first_name=rs.getString("first_name");
                String last_name=rs.getString("last_name");
                double total_amount= rs.getDouble("total_amount");
                arr.add(new PurchaseToday(transaction_id,customer_id,first_name,last_name,total_amount));

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }

    public ArrayList topPurchaseThisMonth() {
        Statement st;
        ResultSet rs;
        ArrayList arr=new ArrayList<>();

        try{
            String query="select c.customer_id,c.first_name,c.last_name,sum(t.total_amount) as total_purchase_amount from customers c\n" +
                    "inner join transactions t on c.customer_id=t.customer_id\n" +
                    "where extract(month from t.transaction_date)=extract(month from current_date )\n" +
                    "group by c.customer_id\n" +
                    "order by total_purchase_amount desc\n" +
                    "limit 10;";
            st=connection.createStatement();
            rs=st.executeQuery(query);
            while (rs.next()){
                int customer_id=rs.getInt("customer_id");
                String first_name=rs.getString("first_name");
                String last_name=rs.getString("last_name");
                double total_amount= rs.getDouble("total_purchase_amount");
                arr.add(new TopCustPurchaseThisMonth(customer_id,first_name,last_name,total_amount));

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }

    public ArrayList topSoldProductsThisMonth() {
        Statement st;
        ResultSet rs;
        ArrayList arr=new ArrayList<>();

        try{
            String query="select p.product_id,p.name,sum(pd.quantity) as total_sold from products p\n" +
                    "inner join purchase_details pd on p.product_id=pd.product_id\n" +
                    "inner join transactions t on t.transaction_id=pd.transaction_id\n" +
                    "where extract(month from t.transaction_date)=extract(month from current_date )\n" +
                    "group by p.product_id\n" +
                    "order by total_sold desc\n" +
                    "limit 10;";
            st=connection.createStatement();
            rs=st.executeQuery(query);
            while (rs.next()){
                int product_id=rs.getInt("product_id");
                String name=rs.getString("name");
                int total_sold= rs.getInt("total_sold");
                arr.add(new TopSoldProductsThisMonth(product_id,name,total_sold));

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }

    public ArrayList unSoldProductsThisMonth() {
        Statement st;
        ResultSet rs;
        ArrayList arr=new ArrayList<>();

        try{
            String query="select p.product_id,p.name,c.category from products p \n" +
                    "left join categories c on c.category_id=p.category_id \n" +
                    "where p.product_id not in ( \n" +
                    "select distinct  pd.product_id from purchase_details pd\n" +
                    " inner join transactions t on t.transaction_id =pd.transaction_id \n" +
                    "where extract(month from t.transaction_date)=extract(month from current_date )\n" +
                    ");";
            st=connection.createStatement();
            rs=st.executeQuery(query);
            while (rs.next()){
                int product_id=rs.getInt("product_id");
                String name=rs.getString("name");
                String category= rs.getString("category");
                arr.add(new UnSoldProductsThisMonth(product_id,name,category));

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }

    public ArrayList revenueByElectronicsProductsThisMonth() {
        Statement st;
        ResultSet rs;
        ArrayList arr=new ArrayList<>();

        try{
            String query="select p.product_id,p.name,coalesce(sum(pd.quantity),0) as total_sold ,\n" +
                    "coalesce(sum(pd.subtotal),0) as total_purchased \n" +
                    "from products p\n" +
                    "left join purchase_details pd on pd.product_id=p.product_id \n" +
                    "inner join categories c on c.category_id=p.category_id \n" +
                    "left join transactions t on pd.transaction_id=t.transaction_id and extract(month from t.transaction_date)=extract(month from current_date)\n" +
                    " where c.category='electronics' \n" +
                    "group by p.product_id,c.category_id\n" +
                    "order by total_purchased desc;";
            st=connection.createStatement();
            rs=st.executeQuery(query);
            while (rs.next()){
                int product_id=rs.getInt("product_id");
                String name=rs.getString("name");
                int quantity= rs.getInt("total_sold");
                double total_sold=rs.getDouble("total_purchased");
                arr.add(new revenueByElectronicsProductsThisMonth(product_id,name,quantity,total_sold));

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return arr;

    }

    public ArrayList soldProductsMoreThan500ThisMonth() {
        Statement st;
        ResultSet rs;
        ArrayList arr=new ArrayList<>();

        try{
            String query="select p.product_id,p.name,c.category,sum(pd.quantity) as sold_quantity from products p\n" +
                    "left join categories c on c.category_id=p.category_id\n" +
                    "left join purchase_details pd on p.product_id=pd.product_id\n" +
                    "left join transactions t on t.transaction_id=pd.transaction_id and extract(month from t.transaction_date)=extract(month from current_date)\n" +
                    "group by p.product_id,c.category_id having sum(pd.quantity) > 500;";
            st=connection.createStatement();
            rs=st.executeQuery(query);
            while (rs.next()){
                int product_id=rs.getInt("product_id");
                String name=rs.getString("name");
                String category=rs.getString("category");
                int sold_quantity= rs.getInt("sold_quantity");
                arr.add(new TopSoldProductsThisMonthMoreThan500(product_id,name,category,sold_quantity));

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }

    public ArrayList purchasesMoreThan50000ThisMonth() {
        Statement st;
        ResultSet rs;
        ArrayList arr=new ArrayList<>();

        try{
            String query="select c.customer_id,c.first_name,c.last_name,sum(t.total_amount) as purchased_amount from customers c\n" +
                    "left join transactions t on t.customer_id=c.customer_id and extract (month from t.transaction_date)=extract(month from current_date)\n" +
                    "group by c.customer_id\n" +
                    "having sum(t.total_amount) >50000;";
            st=connection.createStatement();
            rs=st.executeQuery(query);
            while (rs.next()){
                int customer_id=rs.getInt("customer_id");
                String first_name=rs.getString("first_name");
                String last_name=rs.getString("last_name");
                double total_amount= rs.getDouble("purchased_amount");
                arr.add(new TopCustPurchaseThisMonth(customer_id,first_name,last_name,total_amount));

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }
}
