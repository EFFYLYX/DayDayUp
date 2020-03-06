package reflect;

public class Person{
    private String name;
    private int age;
    public String a;
    public String b;
    public String c;


    public Person(){

    }
    public Person(String name, int age){
        this.name = name;
        this.age= age;
    }
    public void test(){
        System.out.println("invoke");
    }

    public void test(String a){
        System.out.println("invoke"+a);
    }
    public String toString(){

        return "tostring:"+this.name + this.age;
    }
}