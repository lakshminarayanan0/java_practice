public class Person {
    private String name;
    private int age;
    private int salary;

    private String company;

    public Person(String name,int age,int salary,String company){
        this.name=name;
        this.age=age;
        this.salary=salary;
        this.company=company;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company=company;
    }

    public void setSalary(int salary) {
        this.salary=salary;
    }

    public void info(){
        System.out.println("You cannot access my private fields and methods ...lol!");
    }
    private void intro(){
        System.out.println("Hello man !, I am "+this.name+", "+this.age+" years old. Earning Rs."+this.salary+" by working in reputed organisation named "+this.company+".");
        System.out.println("OH my gosh! How you make it visible.");
    }
    private static void stat(){
        System.out.println("This method is static.");
    }
}
