**About some annotations:** 

1)@**Configuration**.(Bean)
In Spring Boot configuration is a class annotation and bean is method annotation. Configuration classes declare beans through Bean-annotated methods.Bean annotation is used to indicate that a method instantiates, configures, and initializes a new object to be managed by the Spring IoC container. Configuration indicates that its primary purpose is as a source of bean definitions. 

2) @**Component**
Component is an annotation that allows Spring to detect our custom beans automatically.
3) @**Service**
Service annotation is a service class declaration ,it is  used for  logicigal implementation.


4) @**SpringBootApplicaiton**
SpringBootApplication annotation is a combination of three annotations and serves as the main entry point for running a Spring Boot application.
@Configuration,@EnableAutoConfiguration,@ComponentScan.

5) @**ResponseBody**
ResponseBody annotation in Spring Boot is used for binding a return value from a resource method to a web 
response body.

6) @**RequestBody**
RequestBody is used to extract the HTTP request body data.Binds the request body to a method parameter.

7) @**Data**
Data annotation is a shortcut that combines the follwing(Getter, Setter,ToString,EqualsAndHashCode,RequiredArgsConstructor) Lombok annotations.
When we use lombok libries in data annotation class will Shorter and more readable,Automatically generated,Easier to maintain and refactor.

8) @**Getter**
Automatically generates getter methods for all fields.

9) @**Setter**
Automatically generates setter methods for all fields (except for final fields).

10)@**Controller**
Used for web controllers in MVC-based applications.

11) @**RestController**
Combines @Controller and @ResponseBody for REST APIs.
Where we first hit from Postman.

12) @**RequestMapping**
RequestMapping annotation is used to map requests to controllers methods.

13)@**Pathvariable**
PathVariable annotation is used to retrieve data from the URL path.Extracts values from the URI path.

14)@**RequestParam**
RequestParam annotation is used to extract query parameters from the URL in HTTP requests. It maps these parameters to method arguments in a controller.

15)@**Autowird**
Injects a Spring-managed bean into another component.

16)@**Bean**
Bean is an object that is managed by the Spring Inversion of Control (IoC) container. Typically used in a @Configuration class to define and register a bean.

17)**Repository**
Indicates data access layer; integrates with database exception translation.

18)**Entity**
Entity annotation to signify that it is a JPA entity. Java classes to database tables and their fields to table columns.

**RESTfull API's:**
19)**Getmapping**
Retrieves resources or data.

20)**Postmapping**
Submits data to create new resources.

21)**PutMapping**
Updates or replaces an existing resource.

22)**Deletemapping**
Deletes or removes a resource.

23)@**Table**
Specifies the table name and other table-level metadata (optional, defaults to class name).

24)@**GeneratedValue**
pecifies how the primary key is generated (e.g., AUTO, IDENTITY, SEQUENCE, TABLE).

25)**OneToOne**	Defines a one-to-one relationship.

26)**OneToMany**	Defines a one-to-many relationship.

27)**ManyToOne**	Defines a many-to-one relationship.

28)**ManyToMany**	Defines a many-to-many relationship.

29)**PrePersist**	Invoked before the entity is persisted.

30)**PostPersist**	Invoked after the entity is persisted.

31)**PreUpdate**	Invoked before the entity is updated.

32)**PostUpdate**	Invoked after the entity is updated.

33)**PreRemove**	Invoked before the entity is removed.

34)**PostRemove**	Invoked after the entity is removed.


   ---**why we use sql driver are  spring boot application.**
   
Answer:
   JDBC Driver allows Java programs to interact with the database.
   Spring Boot JDBC is used to connect the Spring Boot application
   with JDBC by providing libraries and starter dependencies.

---**Collection**:

The Collection in Java framework that provides an architecture to store the group of objects. Java Collections can achieve all the operations like list,set,map and queqe.

The Collections framework three main parts interfaces, classes, and algorithms.

List-Ordered collection of elements,Allows duplicates.ex-ArrayList,LinkedList,MapList.

        List<String> list = new ArrayList<>();
        list.add("nipa");
        list.add("kibria");
        list.add("ritu");
        list.add("kibria"); 
Duplicate allowed.


**Set**-Ordered collection of elements,Not Allows duplicates.ex-HashSet,treeSet.

Set<String> set = new HashSet<>();
set.add("nipa");
set.add("kibria");
set.add("ritu");
set.add("kibria");
System.out.println("Set: " + set);

Duplicate not allowed


**Queue**-Queue always work first in first out,ex-PriorityQueue,ArrayQueue.

Queue<Integer> queue = new PriorityQueue<>();
queue.add(1);
queue.add(2);
queue.add(3);
System.out.println("Queue: " + queue);


**Map**-In map key and value pairs,Must be key always different.ex-HashMap,TreeMap.

Map<Integer, String> map = new HashMap<>();
map.put(1, "nipa");
map.put(2, "kibria");
map.put(3, "ritu");
System.out.println("Map: " + map);
keys must be unique.

**DAO and DTO:**

We know DAO is Data Access Object and DTO means Data Transfer Objects.
DAO- DAO represent a Entity class where we declare some properties.It is directly interact with the JPA Repository.In repository we found all entity properties.

DTO-Dto represent the transfer data object because we need to transfer a data for  differently use.
sometimes we need to few data but we have lots of data in DAO .Then we just create a DTO for few data then those data we used our service and implementation classes.


**MySQL Practice:**

CREATE table STUDENTINFORMATION
(
Roll   int,
Name   varchar(20),
Gender varchar(10),
Age    int(5),
GPA    double(3, 2),
City   varchar(15),
primary key (Roll)
);
select *from STUDENTINFORMATION;

INSERT INTO STUDENTINFORMATION
VALUES
(101,'Nipa','Female',25,3.62,'Dhaka'),
(102,'Ritu','Female',21,2.22,'Dhaka'),
(103,'Kibria','Male',30,3.00,'Dhaka');

INSERT INTO STUDENTINFORMATION
VALUES
(108,'Ariyan','Male',12,4.44,'Pabna'),
(109,'Keya','Female',23,4.33,'Ctg');

select Name from STUDENTINFORMATION;
select *from STUDENTINFORMATION where Roll=101;
select *from STUDENTINFORMATION where Name='Nipa';
select City from STUDENTINFORMATION;
select * from STUDENTINFORMATION LIMIT 4;

SELECT Name FROM STUDENTINFORMATION order by Name;
SELECT Name,Roll,GPA FROM STUDENTINFORMATION order by Name;

SELECT Name FROM STUDENTINFORMATION order by Name DESC ;

select Name,GPA from STUDENTINFORMATION order by GPA;
select Name,GPA from STUDENTINFORMATION order by GPA DESC ;
select 5+2;
select 5/2;

select DISTINCT STUDENTINFORMATION.City from STUDENTINFORMATION where Gender='Female';
select *from STUDENTINFORMATION where Age>=20;
select *from STUDENTINFORMATION where Roll between 102 and 105;
select *from STUDENTINFORMATION where Roll>105 OR City='Dhaka';
select *from STUDENTINFORMATION where Gender='Male' OR GPA<=3.00;

select *from STUDENTINFORMATION where STUDENTINFORMATION.City='Dhaka' AND (Gender='Male' OR GPA<=3.00);
select *from STUDENTINFORMATION where STUDENTINFORMATION.City='Dhaka' AND (Gender='Male' AND GPA<=3.00);
select *from STUDENTINFORMATION where STUDENTINFORMATION.City='Dhaka' OR (Gender='Male' AND GPA<=3.00);
select *from STUDENTINFORMATION where STUDENTINFORMATION.City='Dhaka' OR (Gender='Male' or GPA<=3.00);

select *from STUDENTINFORMATION where STUDENTINFORMATION.City='Dhaka'or City='Pabna' or City='Ctg';

select *from STUDENTINFORMATION where STUDENTINFORMATION.City IN ('Dhaka','Ctg');
select *from STUDENTINFORMATION where STUDENTINFORMATION.City NOT IN ('Dhaka','Ctg');
select *from STUDENTINFORMATION where Name LIKE 'A%';
select *from STUDENTINFORMATION where Name LIKE '%A%';
select *from STUDENTINFORMATION where Name LIKE '%A';

select *from STUDENTINFORMATION where Name LIKE '__p%';
select *from STUDENTINFORMATION where Name LIKE '%y_';
select STUDENTINFORMATION.Roll AS Id ,STUDENTINFORMATION.Name AS 'First Name' from STUDENTINFORMATION;

CREATE TABLE Teacher
(
Id int not null auto_increment,
Name varchar(15) not null ,
Salary double,
primary key (Id)

);

select *from Teacher;

INSERT INTO Teacher
VALUES
(1,'nipa',3.33),
(2,'kibria',2.42),
(3,'Aria',3.62);

INSERT INTO Teacher(Name,Salary)
VALUES
('Jakaria',67),
('Golam',88),
('Sheikh',100);
UPDATE Teacher SET Salary=2.32 where Id=2;
UPDATE Teacher SET Name='Nila' where Id=3;
UPDATE Teacher SET Salary=Salary+2 where Salary<=2;
UPDATE Teacher SET Salary=Salary-2 where Salary>=2;

DELETE  FROM Teacher where Id=2;

SELECT UPPER('I am nipa khatun');
SELECT LOWER('I AM NIPA KHATUN');

select upper(STUDENTINFORMATION.City) from STUDENTINFORMATION;
select upper(STUDENTINFORMATION.City) AS 'City New Name' from STUDENTINFORMATION;
select LOWER(STUDENTINFORMATION.City) from STUDENTINFORMATION;

select concat('Am Nipa',' & Who r u ?');
select concat(STUDENTINFORMATION.Name,' is a ',STUDENTINFORMATION.Age,' years old') As Students from STUDENTINFORMATION;
select greatest(12,80,76,56) ;
select pow(3,2);
select log(2);
select truncate(12.09877,2);
select truncate(log(2),2);
select exp(3);

describe STUDENTINFORMATION;
select count(*) from STUDENTINFORMATION;
select max(STUDENTINFORMATION.GPA) from STUDENTINFORMATION;
select min(STUDENTINFORMATION.GPA) from STUDENTINFORMATION;
select sum(Teacher.Salary) from Teacher;
select avg(Teacher.Salary) from Teacher;

select *
FROM Teacher
where Salary > 44.06166666666667;

select *
FROM Teacher
where Salary > (select avg(Teacher.Salary) from Teacher);

ALTER TABLE Teacher
ADD Age int(5);

ALTER TABLE Teacher
ADD Dept varchar(15);

select *
from Teacher;

ALTER TABLE Teacher
CHANGE Dept Department varchar(15);

ALTER TABLE Teacher
DROP COLUMN Age;

SELECT teacher.Department, SUM(Teacher.Salary)
from Teacher
GROUP BY Teacher.Department
ORDER BY SUM(Salary) DESC;

TRUNCATE TABLE Teacher; /*Only Record Delete hobe*/


CREATE TABLE Exam_Result
(
Reg_Num    int not null,
Roll       int,
GPA        double(3, 2),
Group_Name varchar(15),
primary key (Reg_Num)
);

INSERT INTO Exam_Result
VALUES (1001, 101, 3.22, 'Sceince'),
(1002, 102, 3.44, 'Arts'),
(1003, 103, 3.21, 'Commerce'),
(1004, 104, 3.11, 'Sceience'),
(1005, 105, 4.66, 'Arts');

ALTER TABLE Exam_Result
DROP COLUMN GPA;
select *
from Exam_Result;
select *
from STUDENTINFORMATION;

select *
from STUDENTINFORMATION,
Exam_Result
where STUDENTINFORMATION.Roll = Exam_Result.Roll;

select STUDENTINFORMATION.Roll,
Name,
Exam_Result.Reg_Num,
STUDENTINFORMATION.Age,
Exam_Result.Group_Name,
STUDENTINFORMATION.Gender
from STUDENTINFORMATION,
Exam_Result
where STUDENTINFORMATION.Roll = Exam_Result.Roll;

select STUDENTINFORMATION.Roll,
Name,
Exam_Result.Reg_Num,
STUDENTINFORMATION.Age,
Exam_Result.Group_Name,
STUDENTINFORMATION.Gender
from STUDENTINFORMATION
JOIN Exam_Result ON STUDENTINFORMATION.Roll = Exam_Result.Roll;

select STUDENTINFORMATION.Roll,
Name,
Exam_Result.Reg_Num,
STUDENTINFORMATION.Age,
Exam_Result.Group_Name,
STUDENTINFORMATION.Gender
from STUDENTINFORMATION
INNER JOIN Exam_Result ON STUDENTINFORMATION.Roll = Exam_Result.Roll;

select STUDENTINFORMATION.Roll,
Name,
Exam_Result.Reg_Num,
STUDENTINFORMATION.Age,
Exam_Result.Group_Name,
STUDENTINFORMATION.Gender
from STUDENTINFORMATION
LEFT JOIN Exam_Result ON STUDENTINFORMATION.Roll = Exam_Result.Roll;


select STUDENTINFORMATION.Roll,
Name,
Exam_Result.Reg_Num,
STUDENTINFORMATION.Age,
Exam_Result.Group_Name,
STUDENTINFORMATION.Gender
from STUDENTINFORMATION
RIGHT JOIN Exam_Result ON STUDENTINFORMATION.Roll = Exam_Result.Roll;


CREATE table EmpoloyeeInfo
(
Roll   int,
Name   varchar(20),
Gender varchar(10),
Age    int(5),
GPA    double(3, 2),
City   varchar(15),
primary key (Roll)
);

select *from EmpoloyeeInfo;

INSERT INTO EmpoloyeeInfo
VALUES (113, 'Nila', 'Female', 25, 3.62, 'KUlna'),
(114, 'MIm', 'Female', 21, 2.22, 'Barisal'),
(103, 'Kibria', 'Male', 30, 3.00, 'Dhaka');

SELECT *
from STUDENTINFORMATION
UNION
select *
from EmpoloyeeInfo;

SELECT *
from STUDENTINFORMATION
UNION ALL
select *
from EmpoloyeeInfo;

CREATE VIEW student_view AS
SELECT Roll, Name, Gender
from STUDENTINFORMATION;

select *
from student_view;

UPDATE student_view
Set Name='Anis'
where Roll = 104;

SELECT CURDATE();
select curtime();
select NOW();

select ADDDATE('2024-12-15', INTERVAL 5 day);
select ADDDATE('2024-4-15', INTERVAL 5 MONTH);

SELECT MAKEDATE(2017, 312);
SELECT DAYNAME('2024-12-22');
SELECT MONTHNAME('2024-12-22');



CREATE TABLE Person
(
personId  int(5),
lastName  varchar(15),
firstName varchar(15),
primary key (personId)
);
SELECT *
from Person;
INSERT INTO Person
VALUES (1, 'Wang', 'Allen'),
(2, 'Alice', 'Bob');


CREATE TABLE Address
(
addressId int(5),
personId  int(5),
city      varchar(15),
state     varchar(15),
primary key (addressId)
);
select *
from Address;

INSERT INTO Address
values (1, 2, 'New York', 'NY'),
(2, 3, 'Leetcode', 'California');


select ps.firstName, ps.lastName, ad.city, ad.state
FROM Person ps
Left JOIN Address ad ON ps.personId = ad.personId;

CREATE TABLE Employee
(
id        int(5),
name      varchar(14),
salary    int(6),
managerId int(5),
primary key (id)
);
select *
from Employee;

INSERT INTO Employee
VALUES (1, 'Joe', 70000, 3),
(2, 'Henry', 80000, 4);
INSERT INTO Employee(id, name, salary)
VALUES (3, 'Sam', 60000),
(4, 'Max', 90000);
TRUNCATE TABLE Employee;

select Max(salary)
from Employee;

select *
from Employee
where salary
IN (select Max(salary) from Employee GROUP BY managerId);

select *
from Employee
where managerId = id
AND salary > Employee.managerId;

select e.name AS Employee
from Employee e
inner join Employee e2
on e.managerId = e2.id
where e.salary > e2.salary;


CREATE TABLE PersonTable
(
id    int(5),
email varchar(15)
);
select *
from PersonTable;
INSERT INTO PersonTable
values (1, 'a@.com'),
(2, 'c@.com'),
(3, 'a@.com');

SELECT email,max(id)
FROM PersonTable
GROUP BY  email
HAVING COUNT(email) > 1;


SELECT *
FROM PersonTable;

    SELECT email
    FROM PersonTable

    HAVING COUNT(email) > 1;

SELECT max(id)
FROM PersonTable
GROUP BY email;

SELECT distinct MIN(id) as id
FROM PersonTable
GROUP BY email
having count(email)>1;

WITH dublicateMinimumId AS (
SELECT MIN(id) AS id
FROM PersonTable
GROUP BY email
HAVING COUNT(email) > 1
)
DELETE FROM PersonTable
WHERE id IN (SELECT id FROM dublicateMinimumId);

select * from PersonTable;








CREATE TABLE Customers
(
id   int(5),
name varchar(15),
primary key (id)

);
select *
from Customers;
INSERT INTO Customers
VALUES (1, 'Joe'),
(2, 'Henry'),
(3, 'Sam'),
(4, 'Max');

CREATE TABLE Orders
(
id         int(5),
customerId int(5),
primary key (id)
);
select *
from Orders;

INSERT INTO Orders
values (1, 3),
(2, 1);

select c.name AS Customers
from Customers c
left join Orders o on c.id = o.customerId
where o.customerId is NULL;


CREATE TABLE Person2
(
id    int(5),
email varchar(15)
);
select *
from person2;
INSERT INTO person2
values (1, 'a@.com'),
(2, 'c@.com'),
(3, 'a@.com');


DELETE p
FROM Person2 p
JOIN Person2 p2 ON p.email = p2.email
WHERE p.id > p2.id;

-- 577. Employee Bonus
CREATE TABLE Employee2
(
empId      int(5),
name       varchar(20),
superVisor int(5),
salary     int(5)

);
select *
from Employee2;

INSERT INTO Employee2
values (3, 'Brad', null, 4000),
(1, 'John', 3, 1000),
(2, 'Dan', 3, 2000),
(4, 'Thomas', 3, 4000);

CREATE TABLE Bonus
(
empId int(5),
bonus int(5)
);
select *
from Bonus;
INSERT INTO Bonus
VALUES (2, 500),
(4, 2000);

SELECT e.name, b.bonus
from Employee2 e
Left JOIN Bonus b ON e.empId=b.empId where IFNULL(b.bonus, 0) < 1000; ;

CREATE TABLE Cusomer2
(
id int(5),
name varchar(20),
referee_id int(5),
primary key (id)
);
select *from Cusomer2;
INSERT INTO Cusomer2
values
(1,'Will',null),
(2,'Jane',null),
(3,'Alex',2),
(4,'Bill',null),
(5,'Zack',1),
(6,'Mark',2);


SELECT c.name from Cusomer2 c where c.referee_id is null OR referee_id !=2 ;



CREATE TABLE Weather (
Id INT PRIMARY KEY,
RecordDate DATE NOT NULL,
Temperature INT NOT NULL
);



INSERT INTO Weather (Id, RecordDate, Temperature)
VALUES
(1, '2021-01-01', 10),
(2, '2021-01-02', 25),
(3, '2021-01-03', 20),
(4, '2021-01-04', 30);


SELECT w1.Id
FROM Weather w1
JOIN Weather w2
ON w1.RecordDate = DATE_ADD(w2.RecordDate, INTERVAL 1 DAY)
WHERE w1.Temperature > w2.Temperature;



**InterViewTest**

CREATE DATABASE BusinessAutomation;

use BusinessAutomation;
CREATE TABLE Employees
(
id         int,
name       varchar(15),
occupation varchar(15),
salary     double,
leader_id  int,
primary key (id)
);
SELECT *
FROM Employees;
INSERT INTO Employees
VALUES (1, 'Joshim', 'Doctor', 45000, 1),
(2, 'Aleya', 'Doctor', 15000, 1),
(3, 'Galib', 'Engineer', 12000, 5),
(4, 'Caynath', 'Professor', 17000, 6),
(5, 'Majbah Habib', 'Singer', 35000, 6),
(6, 'Sanjidah', 'Singer', 40000, 0),
(7, 'Jui akter', 'Singer', 20000, 6),
(8, 'Korim', 'Architct', 5000, 5);


CREATE TABLE Salary
(
id              int,
employee_id     int,
month           varchar(15),
given_salary    double,
deferred_amount double,
primary key (id)
);
SELECT *
FROM Salary;
INSERT INTO Salary
VALUES (1, 1, 'January', 45000, 5000),
(2, 1, 'February', 45000, 5000),
(3, 2, 'January', 15000, 500),
(4, 3, 'March', 12000, 120),
(5, 3, 'February', 12000, 120),
(6, 3, 'March', 12000, 0),
(7, 4, 'June', 17000, 1700),
(8, 4, 'July', 17000, 1700),
(9, 4, 'June', 17000, 0),
(10, 5, 'January', 30000, 0),
(11, 5, 'February', 35000, 3500),
(12, 6, 'March', 35000, 250),
(13, 6, 'April', 40000, 500);



SELECT e.name
FROM employees e
where not exists(select 1
from salary s
where e.id = s.employee_id
and trim(lower(s.month)) = 'april');



SELECT e1.name,
e1.occupation,
e1.salary,
(select e2.name from Employees e2 where e2.id = e1.leader_id) as leaderName
FROM Employees e1
ORDER BY e1.salary DESC
limit 1 offset 1;



SELECT *
FROM employees e
where exists(select 1
from salary s
where e.id = s.employee_id
and trim(lower(s.month)) = 'january' AND trim(lower(s.month)) != 'february');


SELECT *
FROM employees e
where exists(select 1
from salary s
where e.id = s.employee_id
and trim(lower(s.month)) = 'january')
and not exists(select 1
from salary s
where e.id = s.employee_id
and trim(lower(s.month)) = 'february');












