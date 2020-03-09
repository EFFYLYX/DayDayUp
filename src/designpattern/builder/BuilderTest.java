package designpattern.builder;

import annotation.Pro;

public class BuilderTest {

    public static void main(String[] args){
        DefaultConcreteProductBuilder builder = new DefaultConcreteProductBuilder();


        Director director = new Director(builder);
        /*
        通过不同的builder传入director，通过不同的建造方式建造product
         */

        Product product = director.makeProduct("pn","cn","p1","p2","p3","p4");
        System.out.println(product);
    }
}

/*
需要生成的对象具有复杂的内部结构
需要生成对象内部属性本身相互依赖
与不可变对象配合使用

建造者独立，易扩展
便于控制细节风险
 */
interface ProductBuilder{
    void builderProductName(String productName);
    void builderCompanyName(String companyName);
    void builderPart1(String part1);
    void builderPart2(String part2);
    void builderPart3(String part3);
    void builderPart4(String part4);

    Product build();



}
class Director{
    private ProductBuilder builder;
    public Director(ProductBuilder builder){
        this.builder=builder;
    }

    public Product makeProduct(String productName,String companyName, String part1,String part2, String part3, String part4){
        builder.builderProductName(productName);
        builder.builderCompanyName(companyName);
        builder.builderPart1(part1);
        builder.builderPart2(part2);
        builder.builderPart3(part3);
        builder.builderPart4(part4);

        Product product = builder.build();
        return product;
    }
}



class DefaultConcreteProductBuilder implements ProductBuilder{

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;


    @Override
    public void builderProductName(String productName) {
        this.productName=productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName=companyName;
    }

    @Override
    public void builderPart1(String part1) {
        this.part1=part1;
    }

    @Override
    public void builderPart2(String part2) {
        this.part2=part2;
    }

    @Override
    public void builderPart3(String part3) {
        this.part3=part3;
    }

    @Override
    public void builderPart4(String part4) {
        this.part4=part4;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
    }
}

class Product{
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    public Product(){}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

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

    public Product(String productName, String companyName, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    public String toString(){
        return this.productName+"\t"+this.companyName + "\t"+this.part1
                +"\t"+this.part2+"\t"+this.part3+"\t"+this.part4;
    }
}
