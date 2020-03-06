package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类
 */
public class RefelectTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /*
        可以创建任意类的对象，可以执行任意方法
        前提，不能改变类的任何代码,只需要更改配置文件
        实现:配置文件，反射


        1. 将需要创建的对象的 全类名， 需要执行的方法 定义在配置文件中
        2. 在程序中加载读取配置文件
        3. 使用反射技术来加载类文件进内存
        4. 创建对象
        5. 执行放方法
         */

        Properties pro= new Properties();

        ClassLoader classLoader = RefelectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

//        3. 使用反射技术来加载类文件进内存
        Class cls = Class.forName(className);

        Object obj = cls.newInstance();


        Method method = cls.getMethod(methodName);
        method.invoke(obj);

     }
}
