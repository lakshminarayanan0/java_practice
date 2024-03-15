public class ThreadVariable {

    private static ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<>(){
        protected  Integer initialValue(){
            return 0;
        }
    };

    public int incrementAndGet() {
        int currentCount = threadLocalCounter.get();
        threadLocalCounter.set(currentCount + 1);
        return currentCount + 1;
    }

    public static void main(String[] args) {
        ThreadVariable counter = new ThreadVariable();

        new Thread(() -> {
            System.out.println("Thread 1: " + counter.incrementAndGet());
        }).start();

        new Thread(() -> {
            System.out.println("Thread 2: " + counter.incrementAndGet());
        }).start();
    }
}
