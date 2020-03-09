package designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<InnerClassSingleton> declared = InnerClassSingleton.class.getDeclaredConstructor();
        declared.setAccessible(true);
        InnerClassSingleton innerClassSingleton = declared.newInstance();

        InnerClassSingleton instance = InnerClassSingleton.getInstance();

        System.out.println(innerClassSingleton==instance);//false


    }
}

