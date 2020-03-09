package designpattern.decorator;

/*
在不改变原有对象的基础上，将功能附加到对象上

扩展一个类的功能或给一个类添加附加职责

不改变原有对象的情况下给一个对象扩展功能
使用不同的组合可以实现不同的效果
符合开闭原则
 */
public class DecoratorTest {

    public static void main(String[] args){
        Component component = new ConcreteComponent();
        component.operation();
        //拍照

        System.out.println("-------------");
        Component component1 = new ConcreteDecorator1(new ConcreteComponent());
        component1.operation();
        //美颜效果
        //拍照

        System.out.println("-------------");
        Component component2 = new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent()));
        component2.operation();
        //滤镜效果
        //美颜效果
        //拍照

    }
}

interface Component{
    void operation();
}

class ConcreteComponent implements Component{

    @Override
    public void operation() {
        System.out.println("拍照");
    }
}


abstract class Decorator implements Component{
    Component component;
    public  Decorator(Component component){
        this.component=component;
    }


}

class  ConcreteDecorator1 extends Decorator{

    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("美颜效果");
        component.operation();
    }
}

class ConcreteDecorator2 extends Decorator{

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("滤镜效果");
        component.operation();
    }
}




