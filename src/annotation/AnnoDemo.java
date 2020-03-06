package annotation;

/**
 * @author  lazybot
 * @version 1.0
 * @since 1.5
 */

@SuppressWarnings("all")
public class AnnoDemo {

    /**
     * 计算两数之和
     * @param a int
     * @param b int
     * @return 两数之和
     */

    public int add(int a, int b) {
//        int x = 3/0;
        return a + b;
    }

    @Deprecated
    public void show1(){

    }

    public void show2(){

    }

    @MyAnno(age = 10, name = "ddd", arr = {1,2,3})
    public void temp(){

        show2();
        show1();
    }

}
