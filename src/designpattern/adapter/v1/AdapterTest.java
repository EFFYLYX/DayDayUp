package designpattern.adapter.v1;

public class AdapterTest {
    public static void main(String[] args){

        Adaptee adaptee = new Adaptee();

        Target target = new Adapter(adaptee);
        target.output5v();//对象适配器看不到output220v()

    }
}

/*
讲一个类的接口转换成客户希望的另一个接口
adpater模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作

对象的适配器模式，采取组合模式

当希望使用某些现有类，但是其接口与其他代码不兼容，使用适配器类
当希望几个现有的子类，但这些子类缺少一些不能添加到超类的公共功能时，使用该模式

符合单一职责原则
符合开闭原则
 */

class Adaptee{
    public int output220v(){
        return 220;
    }


}

interface Target{
    int output5v();
}

class Adapter implements Target{
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int i = adaptee.output220v();
        System.out.println(String.format("原始电压：%d -> 输出电压：%d" ,i,5));


        return 5;
    }
}

