package cn.itcast.junit;
public class Calculator {


    public int add(int a, int b) {
//        int x = 3/0;
        return a + b;
    }

    public int sub(int a, int b) {
        return a-b;
    }


    @Check
    public void mul(){
        System.out.println(1*0);


    }

    @Check
    public void div(){
        System.out.println(1/0);
    }

    @Check
    public void show(){
        System.out.println("no bug");
    }

}