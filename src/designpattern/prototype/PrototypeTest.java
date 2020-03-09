package designpattern.prototype;


/*
可以利用cloneable或者serializable进行原形拷贝

当代吗不应该依赖于需要复制的对象的具体类时

可以不耦合具体类的情况下克隆对象
避免重复的初始化代码
更方便的构建复杂对象
 */

public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        // 为实现baseinfo之前
//        Product product = new Product("p1","p2","p3","p4");
//
//        Product clone = product.clone();
//        System.out.println(product);
//        System.out.println(clone);
//        System.out.println(product == clone);//false
//
//        product.setPart1("ppp");
//        System.out.println(product);
//        System.out.println(clone);
//
//        /*
//        	p1	p2	p3	p4
//        	p1	p2	p3	p4
//        false
//        	ppp	p2	p3	p4
//        	p1	p2	p3	p4
//         */

//
//        /*
//        基本数据类型以及 immutable object包装类行Integer String都可以直接clone,
//        但是baseinfo是mutable object，如果baseinfo没有implements cloneable
//        共享某成员变量信息， baseinfo是同一对象
//         */
//        BaseInfo baseInfo = new BaseInfo("xxx");
//        Product product = new Product("p1","p2","p3","p4",baseInfo);
//        Product clone = product.clone();
//        System.out.println(product);
//        System.out.println(clone);
//        System.out.println(product == clone);//false
//
//        product.setPart1("ppp");
//        System.out.println(product);
//        System.out.println(clone);
//
//        product.getBaseInfo().setCompanyName("yyy");
//        System.out.println(product);
//        System.out.println(clone);
//        /*
//            91044090 p1	p2	p3	p4	 baseinfo: 644117698 xxx
//            1872034366 p1	p2	p3	p4	 baseinfo: 644117698 xxx
//            false
//            491044090 ppp	p2	p3	p4	 baseinfo: 644117698 xxx
//            1872034366 p1	p2	p3	p4	 baseinfo: 644117698 xxx
//            491044090 ppp	p2	p3	p4	 baseinfo: 644117698 yyy
//            1872034366 p1	p2	p3	p4	 baseinfo: 644117698 yyy
//
//         */

        BaseInfo baseInfo = new BaseInfo("xxx");
        Product product = new Product("p1","p2","p3","p4",baseInfo);
        Product clone = product.clone();
        System.out.println(product);
        System.out.println(clone);
        System.out.println(product == clone);//false

        product.setPart1("ppp");
        System.out.println(product);
        System.out.println(clone);

        product.getBaseInfo().setCompanyName("yyy");
        System.out.println(product);
        System.out.println(clone);

        /*
            491044090 p1	p2	p3	p4	 baseinfo: 644117698 xxx
            1872034366 p1	p2	p3	p4	 baseinfo: 1581781576 xxx
            false
            491044090 ppp	p2	p3	p4	 baseinfo: 644117698 xxx
            1872034366 p1	p2	p3	p4	 baseinfo: 1581781576 xxx
            491044090 ppp	p2	p3	p4	 baseinfo: 644117698 yyy
            1872034366 p1	p2	p3	p4	 baseinfo: 1581781576 xxx
         */



    }
}
/*
原型实例指定创建对象的种类，并且通过拷贝这些原形创建新的对象
 */

class BaseInfo implements Cloneable{
    private String companyName;
    public BaseInfo(String companyName){
        this.companyName=companyName;
    }
    public String getCompanyName(){
        return companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    @Override
    protected BaseInfo clone() throws CloneNotSupportedException{
        return (BaseInfo)super.clone();
    }

    public String toString() {
        return " baseinfo: "+super.hashCode() + " " + this.companyName;
    }
}

/*
a class implemenets the Cloneable interface to indicate to the java.lang.Object clone()
method that it is legal for the method
to make a field-for-field copy of instance of that class
 */
class Product implements Cloneable{

    private String part1;
    private String part2;
    private String part3;
    private String part4;

    private BaseInfo baseInfo;


    public Product(){}

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public String getPart4() {
        return part4;
    }

    public void setPart4(String part4) {
        this.part4 = part4;
    }

    public Product( String part1, String part2, String part3, String part4,BaseInfo baseInfo) {

        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.baseInfo=baseInfo;
    }
    public BaseInfo getBaseInfo(){
        return this.baseInfo;
    }

    public String toString(){
        return super.hashCode()+" "+this.part1
                +"\t"+this.part2+"\t"+this.part3+"\t"+this.part4 +"\t"+this.baseInfo;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException{

        Product clone = (Product) super.clone();
        BaseInfo clonebase = this.baseInfo.clone();
        clone.baseInfo = clonebase;
        return clone;
        // super.clone()是个native方法
    }
}