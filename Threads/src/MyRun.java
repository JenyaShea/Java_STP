public class MyRun implements Runnable {
    public static final String R = "\u001B[31m";
    public static final String B = "\u001B[34m";
    public static final String RES = "\u001B[0m";
    @Override
    public void run(){
        for (int i = 0; i <= 100; i++) {
            if (i % 10 == 0) {
                switch (Thread.currentThread().getName()){
                    case "Td1":
                        System.out.println(Thread.currentThread().getName() + ":" + i + " mod 10 = 0" + RES);
                        break;
                    case "Td2":
                        System.out.println(B + Thread.currentThread().getName() + ":" + i + " mod 10 = 0" + RES);
                        break;
                    case "Td3":
                        System.out.println(R + Thread.currentThread().getName() + ": " + i + " mod 10 = 0" + RES);
                        break;
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println();
    }
}
