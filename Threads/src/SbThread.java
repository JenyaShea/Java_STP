public class SbThread extends Thread{
    public static final String R = "\u001B[31m";
    public static final String B = "\u001B[34m";
    public static final String RES = "\u001B[0m";
    private final StringBuilder str_builder;

    public SbThread(StringBuilder stringBuilder) {
        this.str_builder = stringBuilder;
    }

    @Override
    public void run() {
        synchronized (str_builder) {
            for (int i = 0; i < 100; i++) {
                switch (Thread.currentThread().getName()){
                    case "Thread-0":
                        System.out.println(Thread.currentThread().getName() +" " + i +": "+ str_builder + RES);
                        break;
                    case "Thread-1":
                        System.out.println(B + Thread.currentThread().getName() +" " + i +": "+ str_builder + RES);
                        break;
                    case "Thread-2":
                        System.out.println(R + Thread.currentThread().getName() +" " + i +": "+ str_builder + RES);
                        break;
                }

            }
            str_builder.append('a');
        }
    }
}