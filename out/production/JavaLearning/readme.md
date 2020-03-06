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
        - 多用于配置文件，将类名定义在配置文件中。读取文件,加载类
    - 类名.class:通过累名的属性class获取
        - 多用于参数传递
    - 对象.getClass(), getClass方法在object类里定义
        - 多用于对象的获取字节码的方式

同一个字节码文件（.class)在一次程序运行过程中，只会被加载一次

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



可以创建任意类的对象，可以执行任意方法
前提，不能改变类的任何代码,只需要更改配置文件
实现:配置文件，反射


1. 将需要创建的对象的 全类名， 需要执行的方法 定义在配置文件中
2. 在程序中加载读取配置文件
3. 使用反射技术来加载类文件进内存
4. 创建对象
5. 执行放方法
 
 
## 注解 Annotation
- 说明程序，给计算机看

- 也叫元数据，一种代码级别的说明。与类，接口，枚举是同一层次的。可以声明在包，类，字段，方法，局部变量，方法参数掐面米娜，对于这些元素进行说明、注释
- 作用分类：
    - 编写文档：通过代码里的标识的元数据生成文档 在终端 javadoc指令
    - 代码分析：使用反射对代码进行分析
    - 编译检查：让编译器能够实现基本的便已检查【override】

预定义JDK注解
- @Override
- @Deprecated:被标注的内容表示已过时，有更好的替代方法
- @SuppressWarnings:压制警告
    - @SuppressWarnings("all")
    
自定义注解
- 格式：
    
    @元注解
    
    public @interface 元注解名{}
    
    注解的本质就是一个借口，该借口默认继承Annotation借口
    
    public interface MyAnno extends java.lang.annotation.Anotation{}
    
    属性：在接口中可以定义抽象方法
        - 属性的返回值类型
            * 基本数据类型
            * String
            * 枚举
            * 注解
            * 以上类型的数组
        - 定义了属性，使用注解时，需要赋值
            1. 使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性赋值
            2. 如果只有一个属性需要赋值，并且属性的名称是value，则value可以忽略，直接定义值即可
            3. 数组赋值时，值可以用{}包裹，如果数组中只有一个值，则{}可以省略
    
元注解：用于描述注解的注解
    * @Target：描述注解能够作用的位置
        * ElementType.TYPE 类
        * ElementType.METHOD
        * ElementType.FIELD
    * @Retention:描述注解被保留的阶段
    * @Document：描述注解是否被抽取到api文档中
    * @Inherited：描述注解是否被子类继承, 有了这个标注，修饰的父类的注解 会被子类继承
    



