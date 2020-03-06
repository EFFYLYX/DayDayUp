package reflect;

import com.sun.tools.internal.jxc.ap.Const;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectDemo {

    /**
     * - 获取Class对象的方式
     *     - Class.forname("全类名"):将字节码文件加载进内存，返回lass对象
     *     - 类名.class:通过累名的属性class获取
     *     - 对象.getClass(), getClass方法在object类里定义
     */

    public static void main(String[] args) throws ClassNotFoundException {
        Class cls1 = Class.forName("reflect.Person");
        System.out.println(cls1);
        Class cls2 = Person.class;
        System.out.println(cls2);
        Class cls3 = new Person().getClass();
        System.out.println(cls3);

        /**
         * .class文件只会被运行一次，三者都被赋予了统一地址值
         */
        System.out.println(cls1 == cls2);
        System.out.println(cls2==cls3);

        Class c_studnet = Student.class;
        System.out.println(cls1 ==c_studnet);

        System.out.println("=======================");


        System.out.println(Arrays.toString(Person.class.getMethods()));


        Field[] fields = cls1.getFields();//only return public fields
        for(Field field: fields){
            System.out.println(field);
        }

        try {
            Field field_a = cls1.getField("a");


            Person p = new Person();//获取p的a成员变量的值
            Object value = field_a.get(p);
            System.out.println(value);

            field_a.set(p,"hello");//设置p的成员变量对应的值


            cls1.getDeclaredFields();//所有的成员变量，无论是不是private

            Field name = cls1.getDeclaredField("name");
            System.out.println(name);
            name.setAccessible(true);//暴力反射，忽略访问权限检查




        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("=======================");
        System.out.println(Arrays.toString(cls1.getConstructors()));
        /*
          constructor名字都一样，区分靠不同的参数
         */
        try {
            Constructor constructor = cls1.getConstructor(String.class,int.class);
            System.out.println(constructor);

            Object obj = constructor.newInstance("name",10);
            System.out.println(obj.toString());

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Object o = cls1.newInstance();//空参构造
            System.out.println(o.toString());

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("=======================");

        System.out.println(Arrays.toString(cls1.getMethods()));
        try {
            Person p = new Person("xxx",10);

            Method method = cls1.getMethod("test");

            method.invoke(p);

            Method method2 = cls1.getMethod("test",String.class);
            method2.invoke(p,"gggg");



        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }



}
