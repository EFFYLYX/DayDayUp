package designpattern.strategy.badexample;
/*
定义了算法族，分别封装起来，让他们之间可以互相替换，此模式的变化独立于算法的使用者
 */
public class BadExample {
    public static void main(String[] args){

    }
}

abstract class AbstractZombie{
    public abstract void display();

    public void attack(){
        System.out.println("attack");
    }
    public void move(){
        System.out.println("move");
    }

}

class NormalZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("I am normal");
    }
}

class SpecialZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("I am special");
    }
}

class BigHeadZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("My head is big");
    }
}
class XXXZombie extends BigHeadZombie{

    public void move(){
        System.out.println("Move big head");
    }
}