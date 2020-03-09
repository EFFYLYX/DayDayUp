package designpattern.singleton;
/*
单例模式----懒汉模式

延迟加载，只有在真正使用时才开始实例化

线程安全
 */
public class LazySingletonTest {
    public static void main(String[] args){
        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance1 = LazySingleton.getInstance();
        System.out.println(instance==instance1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingleton instance = LazySingleton.getInstance();
                System.out.println(instance);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingleton instance = LazySingleton.getInstance();
                System.out.println(instance);

            }
        }).start();

    }

}

class LazySingleton{
    private static LazySingleton instance;
    private LazySingleton(){}

    public  static LazySingleton getInstance(){
        if( instance==null){
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (LazySingleton.class){
                if(instance==null) {
                    instance = new LazySingleton();
                }
            }


        }
        return instance;
    }
}
