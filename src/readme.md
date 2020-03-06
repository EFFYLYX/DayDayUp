## Junit 单元测试

### 白盒测试

- import org.junit.Test;
- Assert.assertEquals(expected, acuual);
- @Before:修饰的方法会在测试方法之前自动被执行
- @After:修饰的方法会在测试方法之后自动被执行

## 反射：框架设计的灵魂
- 框架：半成品软件，可以在框架的基础上进行软件开发，简化编码
- 反射：将class的各个组成部分封装为其他对象，即反射机制
    -好处：
        - 可以在程序运行过程中，操作这些对象
        - 可以解耦，提高程序的扩展性
- 获取Class对象的方式
    - Class.forname("全类名"):将字节码文件加载进内存，返回lass对象
    - 类名.class:通过累名的属性class获取
    - 对象.getClass(), getClass方法在object类里定义

### java代码 在计算机中经历的三个阶段

#### 源代码阶段
- .java文件 --> javac编译 --> .class文件
    - public class Person{
        private String name;
        private int age;
        public Person(){}
        public void eat(){}
      }
    - .class文件
        - private String name;
          private int age;
        - public Person(){}
        - public void eat(){}

#### Class类对象
.class文件 类加载器ClassLoader
Class 类对象：
- 成员变量 封装成Field对象 Field[] fields
- 构造方法 Constructor对象 Constructor[] cons 
- 成员方法 Method对象 Method[] methods
以上即反射机制
#### Runtime运行时阶段

new Person()



