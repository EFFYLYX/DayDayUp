package cn.itcast.junit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {

    public static void main(String[] args) throws IOException {
        //1. 创界计算器对象
        Calculator cal = new Calculator();

        Class cls = cal.getClass();

        Method[] methods = cls.getMethods();


        int number = 0;

        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for(Method method:methods){
            if (method.isAnnotationPresent(Check.class)){

                try {
                    method.invoke(cal);
                } catch (Exception e) {
                   number++;


                   bw.write(method.getName()+" 有bug");
                   bw.newLine();
                   bw.write("异常名字："+e.getCause().getClass().getSimpleName());
                   bw.newLine();
                   bw.write("异常原因："+e.getCause().getMessage());
                   bw.newLine();
                   bw.write("---------------");
                   bw.newLine();
                }

            }
        }

        bw.write("number of bugs:"+number);
        bw.flush();
        bw.close();

    }
}
