public class Main {
    public static void main(String[] args) {
        //task1();
//        task2();
        task3();
    }
    public static void task1(){
        NewThread thread11 = new NewThread();
        thread11.start();
    }

    public static void task2(){
        Runnable runnable = new MyRun();
        Thread thread21 = new Thread(runnable,"Td1");
        Thread thread22 = new Thread(runnable,"Td2");
        Thread thread23 = new Thread(runnable,"Td3");
        thread21.start();
        thread22.start();
        thread23.start();
    }

    public static void task3(){
        StringBuilder str_builder = new StringBuilder();
        str_builder.append('a');
        SbThread thread31 = new SbThread(str_builder);
        SbThread thread32 = new SbThread(str_builder);
        SbThread thread33 = new SbThread(str_builder);
        thread31.start();
        thread32.start();
        thread33.start();

    }

}