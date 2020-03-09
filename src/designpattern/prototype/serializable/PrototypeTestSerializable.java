package designpattern.prototype.serializable;

import java.io.*;

/*
不推荐使用serializable,消耗性能，速度较慢
 */
public class PrototypeTestSerializable {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 为实现baseinfo之前


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
            895328852 p1	p2	p3	p4	 baseinfo: 1304836502 xxx
            1389133897 p1	p2	p3	p4	 baseinfo: 1534030866 xxx
            false
            895328852 ppp	p2	p3	p4	 baseinfo: 1304836502 xxx
            1389133897 p1	p2	p3	p4	 baseinfo: 1534030866 xxx
            895328852 ppp	p2	p3	p4	 baseinfo: 1304836502 yyy
            1389133897 p1	p2	p3	p4	 baseinfo: 1534030866 xxx
         */



    }

}

class BaseInfo implements Serializable{
    private static final long serialVersionUID =42L;
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

class Product implements Serializable{
    private static final long serialVersionUID =42L;

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


    protected Product clone() throws CloneNotSupportedException{

//        Product clone = (Product) super.clone();
//        clone.baseInfo = this.baseInfo.clone();
//        return clone;
//        // super.clone()是个native方法


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);){

            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try(ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream)){
            return (Product) ois.readObject();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}