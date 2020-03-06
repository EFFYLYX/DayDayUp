package annotation;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Pro(className = "annotation.Show1",methodName = "show")
public class ReflectTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {

        //1.解析注解
        //1.1获取该类的字节码文件对象

        Class<ReflectTest> reflectTestClass = ReflectTest.class;

        //2.获取上边注释的对象
        Pro an = reflectTestClass.getAnnotation(Pro.class);


        //内存中生成了一个该注解接口的子类的实现对象


        /*
        public class ProImpl implements Pro{
            public String className(){

                return "class Name";
            }

            public String methodName(){
                return "method";

            }
        }
         */


        //3. 调用注释对象定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();

        System.out.println(className);
        System.out.println(methodName);


        Class cls = Class.forName(className);

        Method method = cls.getMethod(methodName);

        //        Show1 s = new Show1()
        Object obj = cls.newInstance();

        method.invoke(obj);


    }
}
