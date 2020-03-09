package designpattern.builder.v2;

public class BuilderTest {

    public static void main(String[] args){

        Product product = new Product.Builder().productName("pc").companyName("cn").build();

        System.out.println(product);

        Product.Builder builder = new Product.Builder().companyName("company").part1("p1");
        builder.part3("p3");

        Product product1 = builder.build();
        System.out.println(product1);

    }

}




class Product{
    private final String productName;
    private final String companyName;
    private final String part1;
    private final String part2;
    private final String part3;
    private final String part4;


    static class Builder{
        private String productName;
        private String companyName;
        private String part1;
        private String part2;
        private String part3;
        private String part4;

        /*
        通过return this可以做链式代码
         */

        public Builder productName(String productName){
            this.productName = productName;
            return this;
        }
        public Builder companyName(String companyName){
            this.companyName = companyName;
            return this;
        }

        public Builder part1(String part1){
            this.part1=part1;
            return this;
        }
        public Builder part2(String part2){
            this.part2=part2;
            return this;
        }
        public Builder part3(String part3){
            this.part3=part3;
            return this;
        }
        public Builder part4(String part4){
            this.part4=part4;
            return this;
        }

        public Product build(){
            return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
        }
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


