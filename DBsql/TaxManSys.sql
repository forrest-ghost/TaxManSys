`logrecord``usermanage``usermanage``usermanage``usermanage``carinform``attendance``blacklist``carinform``carreprecords``companyprofit``logrecord``perinform``usermanage``attendance``carinform``carreprecords``companyprofit``dept``logrecord``ordrecord``perinform``salary``usermanage``salary``salary``attendance``attendance``attendance``salary``attendance``salary``attendance``salary``attendance``salary``usermanage``usermanage``attendance``blacklist``logrecord`DROP TABLE Perinform;
CREATE TABLE Perinform(
    id VARCHAR(32) NOT NULL AUTO_INCREMENT  COMMENT '员工编号 用于唯一识别人员身份' ,
    NAME VARCHAR(32)    COMMENT '员工名字 人员姓名' ,
    dept_id VARCHAR(32)    COMMENT '部门编号 部门的标识号' ,
    super_id VARCHAR(32)    COMMENT '上级编号 员工上级标识号' ,
    onboard_date DATE    COMMENT '入职时间 入职时间' ,
    resignation_date DATE    COMMENT '辞职时间 离职时间' ,
    onjob VARCHAR(32)    COMMENT '是否在职' ,`logrecord`
    PRIMARY KEY (id)
) COMMENT = '人员信息 员工管理数据表，负责记录员工的信息，入职和离职，永久保存数据，即便员工离职，信息也不应该立即清除。';

ALTER TABLE Perinform COMMENT '人员信息';
DROP TABLE Carinform;
CREATE TABLE Carinform(
    car_id VARCHAR(32) NOT NULL AUTO_INCREMENT  COMMENT '车辆编号 车辆id' ,
    dept_id VARCHAR(32)    COMMENT '车辆所属部门编号' ,
    onboard_time DATE    COMMENT '服役开始时间 车辆入职时间' ,
    resign_time DATE    COMMENT '服役结束时间' ,
    PRIMARY KEY (car_id)
) COMMENT = '车辆信息 管理车辆信息';

ALTER TABLE Carinform COMMENT '车辆信息';
DROP TABLE Attendance;
CREATE TABLE Attendance(
    id BIGINT NOT NULL   COMMENT '司机编号' ,
    car_id BIGINT    COMMENT '车辆编号' ,
    date DATE    COMMENT '上班日期' ,
    work_time DATETIME    COMMENT '上班时间' ,
    offwork_time DATETIME    COMMENT '下班时间' ,
    workhours INT    COMMENT '工作时长' ,
    PRIMARY KEY (id)
) COMMENT = '出勤记录表 ';

ALTER TABLE Attendance COMMENT '出勤记录表';
DROP TABLE Ordrecord;
CREATE TABLE Ordrecord(
    order_id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '订单号' ,
    id BIGINT    COMMENT '司机编号' ,
    car_id BIGINT    COMMENT '车辆编号' ,
    order_time DATETIME    COMMENT '订单时间' ,
    cost DECIMAL(32,8)    COMMENT '费用' ,
    Journey DECIMAL(32,10)    COMMENT '路程' ,
    PRIMARY KEY (order_id)
) COMMENT = '订单记录 记录司机每一单信息';
/*
订单数据表未使用，无数据
*/
ALTER TABLE Ordrecord COMMENT '订单记录';
DROP TABLE dept;
CREATE TABLE dept(
    dept_id VARCHAR(32) NOT NULL   COMMENT '部门编号' ,
    dept_name VARCHAR(32)    COMMENT '部门名称' ,
    PRIMARY KEY (dept_id)
) COMMENT = '公司部门划分 ';

ALTER TABLE dept COMMENT '公司部门划分';
DROP TABLE Salary;
CREATE TABLE Salary(
    id VARCHAR(32) NOT NULL   COMMENT '司机编号' ,
    year INT NOT NULL   COMMENT '年份' ,
    month INT NOT NULL   COMMENT '月份' ,
    day_num INT    COMMENT '上班天数' ,
    salary_standard DECIMAL(32,8)    COMMENT '薪资标准 一个小时的工资' ,
    wage DECIMAL(32,8)    COMMENT '当月工资' ,
    PRIMARY KEY (id,year,month)
) COMMENT = '某月的司机工资 ';

ALTER TABLE Salary COMMENT '某月的司机工资';
DROP TABLE Carreprecords;
CREATE TABLE Carreprecords(
    record_id VARCHAR(32) NOT NULL   COMMENT '记录编号' ,
    car_id VARCHAR(32)    COMMENT '车辆编号' ,
    repsta_date DATETIME    COMMENT '维修开始日期' ,
    repcom_date DATETIME    COMMENT '维修完成日期' ,
    rep_fees DECIMAL(32,8)    COMMENT '维修费用' ,
    PRIMARY KEY (record_id)
) COMMENT = '车辆维修记录 ';

ALTER TABLE Carreprecords COMMENT '车辆维修记录';
DROP TABLE Companyprofit;
CREATE TABLE Companyprofit(
    year INT    COMMENT '年份' ,
    month INT NOT NULL   COMMENT '月份' ,
    rep_cost DECIMAL(32,8)    COMMENT '维修总费用' ,
    salary_standard DECIMAL(32,8)    COMMENT '薪资标准' ,
    salary_cost DECIMAL(32,8)    COMMENT '司机薪水总支出' ,
    other_cost DECIMAL(32,8)    COMMENT '其它支出' ,
    order_income DECIMAL(32,8)    COMMENT '订单总收入' ,
    other_income DECIMAL(32,8)    COMMENT '其它收入' ,
    total_profit DECIMAL(32,8)    COMMENT '总盈利额' ,
    PRIMARY KEY (month)
) COMMENT = '公司月盈利记录 ';

ALTER TABLE Companyprofit COMMENT '公司月盈利记录';
DROP TABLE Usermanage;
CREATE TABLE Usermanage(
    user VARCHAR(128) NOT NULL   COMMENT '用户账号' ,
    passwd VARCHAR(128)    COMMENT '用户密码' ,
    status VARCHAR(32)    COMMENT '账号状态' ,
    level VARCHAR(32)    COMMENT '用户权限等级' ,
    PRIMARY KEY (user)
) COMMENT = '登录用户管理 ';

ALTER TABLE Usermanage COMMENT '登录用户管理';
DROP TABLE Logrecord;
CREATE TABLE Logrecord(
    Log_id VARCHAR(32)    COMMENT '登录用户名' ,
    passwd VARCHAR(3072)    COMMENT '登录密码' ,
    time DATETIME    COMMENT '登录时间' ,
    Log_ip VARCHAR(128)    COMMENT '登录IP' 
) COMMENT = '登录记录表 ';

ALTER TABLE Logrecord COMMENT '登录记录表';
DROP TABLE Blacklist;
CREATE TABLE Blacklist(
    ip_address VARCHAR(32) NOT NULL   COMMENT '登录IP' ,
    login_time DATETIME    COMMENT '登录时间' ,
    PRIMARY KEY (ip_address)
) COMMENT = '登录IP黑名单 ';

ALTER TABLE Blacklist COMMENT '登录IP黑名单';
