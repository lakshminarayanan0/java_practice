//import java.io.*;
//import java.time.LocalDate;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;


class Main{

     enum Mastery_Level{
         BRONZE,
         SILVER,
         GOLD,
         DIAMOND,
         ELITE,
         HEROIC,
         GRANDMASTER
     }


    public static void main(String[] args) throws Exception {

//         PrimeOrNot obj=new PrimeOrNot();
//        System.out.println(obj.getAllEvenPrime(1999));

//       FindFactorial f=new FindFactorial();
//       f.factorialOf(8);
        System.out.println("hello");

//         Game obj=new Game();
//         obj.score=900;
//        File file=new File("filename.txt");
//        FileOutputStream fos=new FileOutputStream(file);
//        ObjectOutputStream oos=new ObjectOutputStream(fos);
//        oos.writeObject(obj);
//
//        FileInputStream fis=new FileInputStream(file);
//        ObjectInputStream ois=new ObjectInputStream(fis);
//        Game obj1=(Game) ois.readObject();


//        System.out.println(obj1.score);
//        String str="Hello";
//        String original=str;
//        str=str+"oil";
//        System.out.println(original==str);
//        System.out.println(original+" "+str);
//        System.out.println(str);
//         //        Scanner in=new Scanner(System.in);
////        System.out.println("Enter a number: ");
////        int k=in.nextInt();
////        System.out.println(k);
////
////        int sun=factorial(k);
////        System.out.println("sum: "+sun);
////      Third obj=new Third();
////      obj.talk();
////      obj.eat();
//       Person n=new Person();
//       n.nature();
//       n.nature1();
//       n.nature2();
//        String arr[]={ "BRONZE",
//                "SILVER",
//                "GOLD",
//                "DIAMOND",
//                "ELITE",
//                "HEROIC",
//                "GRANDMASTER"};
//        for(String l:arr){
//            System.out.println(l+" "+((Object)l).getClass().getSimpleName());
//        }
//        for(String l:arr){
//            if(l=="BRONZE"){
//                switch (l){
//                    case "GOLD" -> System.out.println("Congrats ! you achieved Gold .");
//                    case "BRONZE" -> System.out.println("Congrats ! you achieved Bronze .");
//                    case "DIAMOND" -> System.out.println("Congrats ! you achieved Diamond .");
//                    case "ELITE" -> System.out.println("Congrats ! you achieved Elite .");
//                    case "HEROI" -> System.out.println("Congrats ! you achieved Heroic .");
//                    case "SILVER" -> System.out.println("Congrats ! you achieved Silver .");
//                    case "GRANDMASTER" ->System.out.println("Congrats ! you achieved Grandmaster .");
//                }
//            }
//        }
//
//       for(Mastery_Level l:Mastery_Level.values()){
//           System.out.println(l+" "+((Object)l).getClass().getSimpleName());
//       }
//        Mastery_Level l=Mastery_Level.GRANDMASTER;
//        switch (l){
//            case GOLD -> System.out.println("Congrats ! you achieved Gold .");
//            case BRONZE -> System.out.println("Congrats ! you achieved Bronze .");
//            case DIAMOND -> System.out.println("Congrats ! you achieved Diamond .");
//            case ELITE -> System.out.println("Congrats ! you achieved Elite .");
//            case HEROIC -> System.out.println("Congrats ! you achieved Heroic .");
//            case SILVER -> System.out.println("Congrats ! you achieved Silver .");
//            case GRANDMASTER ->System.out.println("Congrats ! you achieved Grandmaster .");
//        }
//        LocalDate d= LocalDate.now();
//        System.out.println(d);
//
//        ArrayList<Integer> nums=new ArrayList<>();
//        nums.add(987);
//        nums.add(91);
//        nums.set(0,123);
//        nums.remove(0);
//        for(int i=100;i<9000;i=i+876)
//            nums.add(i);
//        Collections.sort(nums,Collections.reverseOrder());
//        System.out.println(nums);
//
//        HashMap<Integer,String> employees=new HashMap<>();
//        employees.put(1,"Balaji");
//        employees.put(2,"Hari");
//        employees.put(3,"Guna");
//        employees.put(4,"Arun");
//        employees.put(5,"Sriram");
//        System.out.println(employees);
//
//        for(int i:employees.keySet())
//            System.out.println(employees.get(i)+" "+i);
//
//        HashSet<String>num=new HashSet<>();
//        num.add("Roman");
//        num.add("jhon ");
//        for (int i=0;i<5;i++)
//            num.add("Brock Lesnar");
//        System.out.println(num);
//
//        try{
//            for(int i=0;i<15;i++){
//                System.out.println(nums.get(i));
//            }
//        }catch (Exception e) {
//            System.out.println(e);
//        }finally {
//            System.out.println("Try catch executed");
//        }
//
//
//        Pattern pat=Pattern.compile("cat",Pattern.CASE_INSENSITIVE);
//        ArrayList<String> words=new ArrayList<>();
//        String arr[]={"Actor","Axtyh","trecat","camera"};
//        for (String item:arr){
//            Matcher match=pat.matcher(item);
//            Boolean isFind=match.find();
//
//            if (isFind){
//               words.add(item);
//            }
//        }
//        System.out.println(words);
//
//        File file=new File("filename.txt");
////        try {
////            if (file.createNewFile()){
////                System.out.println("File created successfully with name of "+file.getName());
////            }
////            else {
////                System.out.println("failed to create file.");
////            }
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
//        System.out.println(file.getAbsolutePath());
//        try (FileWriter writer = new FileWriter(file.getAbsolutePath())) {
//            writer.write("Many quatker more baby tang shikim");
//            writer.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Scanner read=new Scanner(file);
//        while (read.hasNextLine()){
//            String out=read.nextLine();
//            System.out.println(out);
//        }
//       read.close();
    }



     static int factorial(int k) {
        if(k==0){
            return 1;
        }
        return k*factorial(k-1);
    }

    static  int sum(int k){
        if(k==0){
            return 0;
        }
       return k+ sum(k-1);
    }
}
//class Game implements Serializable{
//    int score;
//}