/*创建数据库*/
CREATE DATABASE taxmansys;

创建用户test,密码123456；
CREATE USER 'test'@'localhost' identified BY '123456';
SELECT user,host from mysql.user;

用户test赋权，test用户有taxmansys数据库的所有权；（select,create,delete,等的所有权）
GRANT all on taxmansys.* to 'test'@'localhost';
show grants for 'test'@'localhost';