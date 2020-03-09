package designpattern.singleton;

public class HungrySingletonTest {
    public static void main(String[] args){


        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1 = HungrySingleton.getInstance();
        System.out.println(instance==instance1);
    }
}
/*
只有在真正使用对应的雷士，才会触发初始化
例如当前类是main函数所在类，直接进行new操作，访问静态属性、访问静态方法，用反射访问类，初始化一个类的子类等
 */
class HungrySingleton{


    private static HungrySingleton instance = new HungrySingleton();
    //类加载的初始化阶段就完成了实例化,赋值初始值，借助jvm类加载机制，保证实例的唯一性


    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return instance;
    }
}