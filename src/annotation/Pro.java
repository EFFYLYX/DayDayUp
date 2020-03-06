package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {

    String className();
    String methodName();
}


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
