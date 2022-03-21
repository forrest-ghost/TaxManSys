DBsql文件夹:
createtaxmansys.sql文件生成数据库taxmansys;
创建用户test,密码123456；

第三段代码给用户test赋权，test用户有taxmansys数据库的所有权；（select,create,delete,等的所有权);

TaxManSys.sql文件:
创建数据表和插入数据,注意时间格式:日期为:xxxx-xx-xx,(年-月-日,年份为四位,月份为两位，天为两位，如2021-07-01,格式必须规定为指定位数);

src目录：
database.properties为配置数据库连接文件;
com\ssdut\taximanage:
dao下类为数据库操作接口类；
dao\impl：为dao接口的实体化类

entity:为数据表类，一个类对应一个数据表;

service:为服务接口定义；
service\impl：为服务接口实现类

test:Main函数部分；程序入口；