package designpattern.adapter.v2;

public class AdapterTest {
    public static void main(String[] args){
        Adapter adapter = new Adapter();
        adapter.output5v();
        adapter.output220v();//类适配器可以使用adaptee的方法


    }
}


class Adaptee{
    public int output220v(){
        return 220;
    }


}

interface Target{
    int output5v();
}

class Adapter extends Adaptee implements Target{

    @Override
    public int output5v() {
        int i = super.output220v();
        System.out.println(String.format("原始电压：%d -> 输出电压：%d" ,i,5));


        return 5;
    }
}