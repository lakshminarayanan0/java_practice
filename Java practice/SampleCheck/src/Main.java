public class Main {
    public static void main(String[] args) {

     Tables table=new Tables();
        Thread t1=new Thread(()->table.printTable(5));
        Thread t2=new Thread(()->table.printTable(13));
        t1.start();
        t2.start();

    }
}
class Tables {


    synchronized public void printTable(int n) {
        System.out.println("Printing "+n+"th Table...");
        for (int i=1;i<=10;i++){
            System.out.println(n+" x "+i+" = "+n*i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}