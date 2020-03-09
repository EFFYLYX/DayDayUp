package designpattern.facade;
/*
为子系统中的一组接口提供给一个一致的接口，
facade模式定义了一个高层接口，这个接口使得这一子系统更容易使用
 */
public class FacadeTest {
    public static void main(String[] args){

    }
}

class Client{
    Facade facade = new Facade();
    public void doSomething(){
        facade.doSomethingFacade();
    }
}
class Facade{
    /*

    SubSystem1 subsystem1 = new SubSystem1();
    SubSystem2 subsystem2 = new SubSystem2();
    SubSystem3 subsystem3 = new SubSystem3();


     */
    public void doSomethingFacade(){

        /*
        subsystem1.method1();
        subsystem2.method2();
        subsystem3.method3();
         */

    }
}
