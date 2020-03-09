package designpattern.singleton;

public class InnerClassTest {

    public static void main(String[] args){
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();

        System.out.println(instance==instance1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                InnerClassSingleton instance = InnerClassSingleton.getInstance();
                System.out.println(instance);

            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                InnerClassSingleton instance = InnerClassSingleton.getInstance();
                System.out.println(instance);

            }
        }).start();
    }
}
/*
利用类的加载机制来保证线程安全
只有在实际使用的时候，才会触发类的初始化，所以也是懒加载的一种形式
 */
class InnerClassSingleton{
    private static class InnerClassHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton(){

    }



    public static InnerClassSingleton getInstance(){
        return InnerClassHolder.instance;
    }
}
