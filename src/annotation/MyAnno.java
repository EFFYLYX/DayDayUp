package annotation;

import reflect.Person;

import java.lang.annotation.*;


//@Target(value={ElementType.TYPE})//表示该注解只能作用在类上而不能在成员变量或方法上
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented//可以在javadoc里出现
@Inherited
public @interface MyAnno {

    int age();
    String name();
    String str() default  "default";
    int[] arr();
    MyEnum myEnum() default MyEnum.CLASS;


}
