package designpattern.abstractfactory;

public class AbstractFactoryTest {

    public static void main(String[] args){
        IDatabaseUtils iDatabaseUtils = new MysqlUtils();
        IConnection connection = iDatabaseUtils.getConnection();
        connection.connect();

        ICommand command = iDatabaseUtils.getCommand();
        command.command();

    }
}

/*
提供一个创建一系列相关或互相依赖对象的接口，而无需指定他们具体的类

程序需要处理不同系列的相关产品，但是不希望依赖这些产品的具体类

确信从工厂的产品彼此兼容
可以避免具体产品和客户端代码之间的紧密耦合
符合单一职责原则
符合开闭原则
 */
interface IConnection{
    void connect();
}
interface ICommand{
    void command();


}

interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}
class MysqlConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("mysql connec");
    }
}

class MysqlCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("mysql command");
    }
}

class MysqlUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return  new MysqlCommand();
    }
}



