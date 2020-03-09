package designpattern.strategy;

public class StrategyTest {
    public static void main(String[] args){

        Zombie zombie = new NormalZombie();
        zombie.display();
        zombie.attack();
        zombie.move();

        /*
        i am normal
        Hit
        walk

         */

        zombie.setAttackable(new BiteAttack());
        zombie.display();
        zombie.attack();
        zombie.move();
        /*
        i am normal
        Bite
        walk
         */

        Zombie zombie1 = new SpecialZombie();
        zombie1.display();
        zombie1.attack();
        zombie1.move();
        /*
            i am special
            Bite
            walk
         */


    }
}

interface Moveable{
    void move();
}

interface Attackable{
    void attack();
}

abstract class Zombie{
    abstract public void display();

    Moveable moveable;
    Attackable attackable;

    abstract void move();
    abstract void attack();

    public Zombie(Moveable moveable, Attackable attackable){
        this.moveable=moveable;
        this.attackable=attackable;
    }

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }
}
class BiteAttack implements Attackable{

    @Override
    public void attack() {
        System.out.println("Bite");
    }
}
class HitAttack implements Attackable{

    @Override
    public void attack() {
        System.out.println("Hit");
    }
}

class WalkMove implements Moveable{

    @Override
    public void move() {
        System.out.println("walk");
    }
}
class NormalZombie extends Zombie{

    public NormalZombie(){
        super(new WalkMove(), new HitAttack());
    }

    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("i am normal");

    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
}
}

class SpecialZombie extends Zombie{
    public SpecialZombie(){
        super(new WalkMove(),new BiteAttack());
    }

    public SpecialZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("i am special");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();

    }
}

