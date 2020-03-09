package designpattern.factory;
/*
工厂模式
顶一个用于创建对象的接口，瓤子类决定实例化哪一个类

当不知道该使用对象的确切类型的时候
希望为库或框架提供扩展器内部组件的方法是

将具体产品和创建者解耦
符合单一职责原则
符合开闭原例
 */
public class FactoryMethod {


    public static void main(String[]args) {
        Application application = new ConcreteProductA();
        Product p = application.getObject();
        p.method1();
//
//
//        Product p2 = application.getObject("B");
//        p2.method1();

    }



}


class SimpeFactory{
    static Product createProduct(String type){

        switch (type){
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
        }

        return null;
    }
}
abstract class Application {
//    private Product createProduct(String type){
//        return SimpeFactory.createProduct(type);
//    }
    abstract Product createProduct();
    Product getObject(){
        return createProduct();
    }
}

interface Product {
    public void method1();
}


class ProductB implements Product {
    @Override
    public void method1() {
        System.out.println("ProductB.method1 executed.");

    }
}

class ProductA implements Product {
    @Override
    public void method1() {
        System.out.println("ProductA.method1 executed.");

    }


}

class ConcreteProductA extends Application{

    @Override
    Product createProduct() {
        return new ProductA();
    }
}

