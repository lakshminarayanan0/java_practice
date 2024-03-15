
public class InstanceVariable {

    private int count = 0;

    public int incrementAndGet() {
        return ++count;
    }

    public static void main(String[] args) {
        InstanceVariable counter = new InstanceVariable();

        String classPath=System.getProperty("java.class.path");
        System.out.println(classPath);
        // Thread 1 increments the counter
        new Thread(() -> {
            System.out.println("Thread 1: " + counter.incrementAndGet());
        }).start();

        // Thread 2 increments the counter
        new Thread(() -> {
            System.out.println("Thread 2: " + counter.incrementAndGet());
        }).start();
    }
}
