## 数据库基本概念

数据化的特点：
1. 持久化存储数据的
2. 方便存储和管理数据
3. 使用统一的的方式操作数据库 SQL


``
mysql -u root -p
``

- DDL

   - data definition language
   - 操作数据库、表
   - CREATE, DROP, ALTER

- DML
    - manipulation
    - 增删改表中的数据
    - INSERT, DELETE, UPDATE
- DQL
 - query
 - 查询
 - SELECT, WHERE
- DCL
    - control
    
    
## DDL

1. 操作数据库 CRUD
    1. CREATE
        * CREATE DATABASE db1;
            * CREATE DATABASE if not exists db1;
            * CREATE DATABASE if not exists db2 character set gbk;
                * 指定字符集
    2. RETRIEVE
        * 查询所有数据库的名称
            * show databases;
        * 查询某个数据库的字符集
            * show create database 数据库名字;     
    3. UPDATE
        * ALTER database 数据库名称 character set 字符集名字;
    4. DELETE
        * DROP database 数据库名称;
        * DROP database if exists 数据库名称;
    5. 使用数据库
        * 查询当前正在使用的数据库名称
            * select database();
        * use 数据库名; 
2. 操作表 CRUD
    1. create
        * create table table_name(
            id int,
            name varchar(20),
            age int,
            score double(4,1),
            birthday datetime,
            insert_time timestamp);
        * create table like table_name;
            * 复制
        * 常见数据类型
            * int, 
            * double(5,2), 一共五位，小数之后有2位
            * date, yyyy-MM-dd
            * datetime, yyyy-MM-dd HH:mm:ss
            * timestamp, yyyy-MM-dd HH:mm:ss, 如何不赋值，默认赋值为当前系统时间
            * varchar,字符串, varchar(20)最多20字符                      
    2. retrieve
        * 查询数据库中所有的表名字
            * show tables;
        * 查询表结构
            * desc 表名;
    3. update
        * 修改表名
            * alter table table_name rename to new_table_name
        * 修改表字符级
            * ALTER TABLE table_name CHARACTER SET new_character_set_name
        * 添加一列
            * ALTER TABLE table_name ADD column_name data_type; 
        * 修改列名称 类型
            * ALTER TABLE table_name CHANGE column_name new_column_name new_data_type;
            * ALTER TABLE table_name MODIFY column_name new_data_type;
        * 删除列
            * ALTER TABLE table_name DROP column_name;
    4. delete
        * drop table if exists table_name
        * drop table table_name
        
        
## DML 
1. 添加数据
    * INSERT INTO table_name(column_name1, column_name2,....) VALUES(v1,v2,.....);
    * 不定义列明，则给所有的列都添加数据
2. 删除数据
    * DELETE FROM table_name [WHERE condition];
        * 不加条件，删除所有记录
    * 删除所有记录
        * DELETE FROM table_name;
            * **不推荐使用，有多少条记录就会执行多少次删除操作**
        * TRUNCATE TABLE table_name
            * 先删除表，在创建一样的表，只执行了DROP和CREATE两次操作
3. 修改数据
    * UPDATE table_name SET column_name = value, column_name = value, .... [WHERE ];
        * 如果不加任何条件，则会将表中所有数据都修改


## DQL
1.  查询：
    * SELECT 
        * \* -- 或者 column_1, column_2 ...
    * FROM 
        * table_name 
    * WHERE 
        * -- 条件 
        * age>= 20 AND age <=30 
        * age BETWEEN 20 AND 30
        * english = NULL 不对，必须用engish IS NULL
    * GROUP BY 
        * -- 分组字段
    * HAVING 
        * -- 分组之后的条件
    * ORDER BY 
        * -- 排序
    * LIMIT 
        * -- 分页限定
        
    - SELECT DINSTINCT column_name FROM table_name
    
    - 计算列
        * 一般可以使用size运算
        *   IFNULL（表达式1，表达式2）
    - AS 
        * 起别名
2. 排序查询
    ORDER BY column_name ASC/DESC, column_name ASC/DESC
    * 第一排序条件，第二排序条件
3. 聚合函数
    * count
        * SELECT COUNT(column_name) FROM table_name
        * 选择非空列，或者使用IFNULL() 
    * max
    * min
    * sum
    * avg
4. 分组查询
    * SELECT column_name_group, 聚合函数 FROM table_name [WHERE] GROUP BY clumn_name_group [HAVING]
    * where 和 having 的差别
        * where在分组之前限定，如果不满足条件，不参与分组
        * having在分组之后进行限定，如果不满足条件，则不会被select出来
        * where后不可以跟聚合函数， having后可以进行聚合函数的判断
5. 分页
    * SELECT * FROM table LIMIT 0,3 -- first page
    * SELECT * FROM table LIMIT 3,3 -- second page
    * 开始的索引 = （当前页码 - 1） * 每页显示的条数
    
## 约束
1. 主键约束， primary key
    * 一个表只能有一个逐渐，逐渐是表记录的唯一标识
    * 删除主键：ALTER TABLE table_name DROP PRIMARY KEY
    * 添加主键：ALTER TABLE table_name MODIFY id INT PRIMARY KEY
    * 自动增长：
        * CREATE TABLE table_name{id INT PRIMARY KEY AUTO_INCREMENT, other_columns);
2. 非空约束：not null
    * CREATE TABLE table_name(id INT, name VARCHAR(20) NOT NULL)
        * name 为非空
3. 唯一约束：unique
   * CREATE TABLE table_name(id INT, phone VARCHAR(20) UNIQUE)
4. 外键约束：foreign key
    * CREATE TABLE table_name .... column_name CONSTRAINT foreign_column_name FOREIGN KEY (column_name) REFERENCES foreign_table_Name(primary_key_name))
    * ALTER TABLE table_name DROP FOREIGN KEY foreign_key_name
    * ALTER TABLE table_name ADD CONSTRAINT foreign_column_name FOREIGN KEY (column_name) REFERENCES foreign_table_Name(primary_key_name))
    
    * 级联操作
        * ON UPDATE CASCADE ON DELETE CASCADE
        * 级联更新 ON UPDATE CASCADE
        * 级联删除 ON DELETE CASCADE
            * 跟这条记录相关的所有记录(包括其他表）都删除了

## 数据库设计
1. 多表关系
    1. 一对一
        * yi个人
    2. 一对多、多对一
    3. 多堆垛
    
    