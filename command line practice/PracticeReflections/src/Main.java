import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {

        Person obj=new Person("Balaji",21,15000,"Chakraa");
        Class cls=obj.getClass();
        Method[] meth=cls.getDeclaredMethods();
        Field[] field=cls.getDeclaredFields();

        for (Method method:meth){
            if(method.getName().equals("stat")){
                method.setAccessible(true);
                method.invoke(null);
            }
        }


        for (Field fie:field){
            if(fie.getName().equals("name")){
                System.out.println(obj.getName());
                fie.setAccessible(true);
                fie.set(obj,"Marrygo");
                System.out.println(obj.getName());
            }


        }

    }
}