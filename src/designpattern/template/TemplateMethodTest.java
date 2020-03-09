package designpattern.template;

public class TemplateMethodTest {
    public static void main(String[] args){
        AbstractClass abstractClass = new SubClass();
        abstractClass.operation();
        /*
        step 1
        step 2
        step 3
        Sub template
        step 4

         */
    }
}
abstract class AbstractClass{
    public void operation(){
        System.out.println("step 1");
        System.out.println("step 2");
        System.out.println("step 3");
        templateMethod();
        System.out.println("step 4");

    }
    abstract protected void templateMethod();
}

class SubClass extends AbstractClass{

    @Override
    protected void templateMethod() {
        System.out.println("Sub template");
    }
}
