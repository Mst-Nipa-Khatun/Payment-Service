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




Bussiness Automation Assignment Self Solve:

CREATE DATABASE db_assessment;
use db_assessment;

CREATE TABLE `courses` (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
`title` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`credit` double(3,2) NOT NULL,`created_at` datetime DEFAULT NULL,
`updated_at` datetime DEFAULT NULL,
PRIMARY KEY (`id`)
);
select *from courses;
INSERT INTO `courses` (`id`, `name`, `title`, `credit`, `created_at`, `updated_at`)
VALUES
(1, 'CSE 111', 'Introduction of Computer Science', 3.00, NULL, NULL),
(2, 'CSE 112', 'Analog Electronics', 3.00, NULL, NULL),
(3, 'MATH 121', 'Integral Calculus & Differential Equation', 2.00, NULL, NULL),
(4, 'CSE 231', 'Theory of Computation', 3.00, NULL, NULL),
(5, 'CSE 293', 'Digital System Design', 3.00, NULL, NULL),
(6, 'CSE-333', 'Computer Network', 3.00, NULL, NULL),
(7, 'CSE-313', 'Operating System', 3.00, NULL, NULL);




CREATE TABLE `teachers` (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
`mobile` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
`gender` enum('male','female') COLLATE utf8mb4_general_ci NOT NULL,
`address` text COLLATE utf8mb4_general_ci,
`created_at` datetime DEFAULT NULL,
`updated_at` datetime DEFAULT NULL,
PRIMARY KEY (`id`)
);
select *from teachers;
INSERT INTO `teachers` (`id`, `name`, `email`, `mobile`, `gender`, `address`, `created_at`, `updated_at`) VALUES
(1, 'Fuad al Muqtadir', 'fuad@gmail.com', '','male', 'Dhaka', '2024-04-30 14:22:08', '2024-04-30 14:21:46'),
(2, 'Saiful Alam', 'saiful@gmail.com', '','male', 'Chittagong',  '2024-04-30 14:21:55', '2024-04-30 14:21:55'),
(3, 'Nusrat Jahan Tania', 'tania@gmail.com', '','female',  ' ', '2024-04-30 14:22:00', '2024-04-30 14:22:00'),
(4, 'Hasibul Islam', 'hasibul@gmail.com', '','male', 'Chittagong',  '2024-04-30 14:22:03', '2024-04-30 14:22:03'),
(5, 'Israt Jahan', 'israt@gmail.com', '','female', ' ', '2024-04-30 14:22:06', '2024-04-30 14:22:06'),
(6, 'Mohammad Sharif Uddin', 'uddin@gmail.com', '','male', 'Chittagong', '2024-04-30 14:22:08', '2024-04-30 14:22:08'),
(7, 'Amran hasan', 'hasan@gmail.com', '','male', 'Dhaka', '2024-04-30 14:22:08', '2024-04-30 14:22:08'),
(8, 'Prof. Dr. Fatema Ashraf', 'ashraf@gmail.com', '','female', 'Chittagong',  '2024-04-30 14:22:10', '2024-04-30 14:22:10'),
(9, 'Saiful Alam', 'saiful@gmail.com', ' ', 'male', 'Chittagong', '2024-04-30 14:22:12', '2024-04-30 14:22:12'),
(10, 'Majbah Uddin Habib', 'habib@gmail.com', '', 'male', 'Chittagong', '2024-04-30 14:22:18', '2024-04-30 14:22:18');



CREATE TABLE `semesters` (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`year` year NOT NULL,
`created_at` datetime DEFAULT NULL,
`updated_at` datetime DEFAULT NULL,
PRIMARY KEY (`id`)
);
select *from semesters;
INSERT INTO `semesters` (`id`, `name`, `year`)
VALUES
(1,'Fall',2023),
(2,'Winter',2023),
(3,'Spring',2023),
(4,'Fall',2024),
(5,'Winter',2024),
(6,'Spring',2024);



CREATE TABLE `students` (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
`email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
`mobile` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
`gender` enum('male','female') COLLATE utf8mb4_general_ci NOT NULL,
`address` text COLLATE utf8mb4_general_ci,
`status` int DEFAULT NULL,
`created_at` datetime DEFAULT NULL,
`updated_at` datetime DEFAULT NULL,
`created_by` int DEFAULT NULL,
`updated_by` int DEFAULT NULL,
PRIMARY KEY (`id`)
);
select *from students;

INSERT INTO `students`
(`id`, `name`, `email`, `mobile`, `gender`, `address`, `status`, `created_at`, `updated_at`, `created_by`, `updated_by`)
VALUES
(1, 'Khalid Hossain', 'khalid@gmail.com', '01854422700, 01854422701, 01854422702', 'male', 'Dhaka, Bangladesh', 1, '2024-04-30 14:28:14', '2024-04-30 14:27:45', 2, NULL),
(2, 'Fakruddin Ahmed', 'fakruddin@gmail.com', '01854422703, 01854422704, 01854422705', 'male', 'Natore, Bangladesh', 1, '2024-04-30 14:28:14', '2024-04-30 14:27:49', 1, NULL),
(3, 'Sanjeeb Choudhury', 'sanjeeb@gmail.com', '01854422706, 01854422707, 01854422708', 'male', 'Habiganj, Bangladesh', 0, '2024-04-30 14:28:14', '2024-04-30 14:27:52', 1, NULL),
(4, 'Jannatul Arefin', 'jannatu@gmail.com', '01854422709, 01854422710, 01854422711', 'female', 'Sylhet, Bangladesh', 1, '2024-04-30 14:28:14', '2024-04-30 14:27:55', 2, NULL),
(5, 'Shayan Chowdhury Arnob', 'arnob@gmail.com', '01854422712, 01854422713, 01854422714', 'male', 'Gazipur, Bangladesh', 1, '2024-04-30 14:28:14', '2024-04-30 14:28:14', 1, NULL),
(6, 'Nazmul Abedeen Fahim', 'fahim@gmail.com', '01854422715, 01854422716, 01854422717', 'male', 'Khulna, Bangladesh', 2, '2024-04-30 14:28:14', '2024-04-30 14:28:14', 2, NULL),
(7, 'Kaniz Fatema', 'kaniz@gmail.com', '01854422707', 'female', 'Dhaka, Bangladesh', 2, '2024-04-30 14:28:14', '2024-04-30 14:28:14', 1, NULL),
(8, 'Iftekhar Ahmed Chowdhury', 'iftekhar@gmail.com', '01854422708', 'male', 'Dhaka, Bangladesh', 2, '2024-04-30 14:28:14', '2024-04-30 14:28:14', 1, NULL),
(9, 'Ataur Rahman Khan', 'khan@gmail.com', '01854422709', 'male', 'Kushtia, Bangladesh', 2, '2024-04-30 14:28:14', '2024-04-30 14:28:14', 2, NULL),
(10, 'Samiha Tahsen Orna', 'samiha@gmail.com', '01854422710', 'female', 'Dhaka, Bangladesh', 1, '2024-04-30 14:28:14', '2024-04-30 14:28:14', 1, NULL),
(11, 'Ananta Jalil', 'jalil@gmail.com', '01854422711', 'male', 'Bhola, Bangladesh', 0, '2024-04-30 14:28:14', '2024-04-30 14:28:14', NULL, NULL),
(12, 'Saif Ahmad', 'saif@gmail.com', '01854422712', 'male', 'Munshiganj, Bangladesh', 2, '2024-04-30 14:28:14', '2024-04-30 14:28:14', 2, NULL),
(13, 'Farhana Rahman', 'farhana@gmail.com', '01854422713', 'female', 'Keraniganj, Bangladesh', 2, '2024-04-30 14:28:14', '2024-04-30 14:28:14', 2, NULL),
(14, 'Khalid Hossain', 'khalid@gmail.com', '01854422714', 'male', 'Khulna, Bangladesh', 0, '2024-04-30 14:28:14', '2024-04-30 14:28:14', NULL, NULL);



CREATE TABLE `course_wise_teacher` (
`id` int NOT NULL AUTO_INCREMENT,
`teacher_id` int NOT NULL,
`course_id` int NOT NULL,
`semester_id` int NOT NULL,
`created_at` datetime DEFAULT NULL,
`updated_at` datetime DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `teacher_id` (`teacher_id`),
KEY `course_id` (`course_id`),KEY `semester_id` (`semester_id`),
CONSTRAINT `course_wise_teacher_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`),
CONSTRAINT `course_wise_teacher_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
CONSTRAINT `course_wise_teacher_ibfk_3` FOREIGN KEY (`semester_id`) REFERENCES `semesters` (`id`)
);
select *from course_wise_teacher;

INSERT INTO `course_wise_teacher`
(`id`, `teacher_id`, `course_id`, `semester_id`, `created_at`)
VALUES
(1, 1, 1, 6, '2024-04-29 13:40:59'),
(2, 2, 1, 6, '2024-04-29 13:40:59'),
(3, 1, 2, 5, '2024-04-29 13:40:59'),
(4, 3, 3, 6, '2024-04-29 13:40:59'),
(5, 4, 4, 6, '2024-04-29 13:40:59'),
(6, 5, 5, 6, '2024-04-29 13:40:59'),
(7, 6, 6, 6, '2024-04-29 13:40:59'),
(8, 7, 7, 6, '2024-04-29 13:40:59'),
(10, 1, 1, 1, '2024-04-29 13:40:59'),
(11, 1, 1, 3, '2024-04-29 13:40:59'),
(12, 2, 2, 3, '2024-04-29 13:40:59'),
(13, 2, 2, 1, '2024-04-29 13:40:59'),
(14, 3, 3, 1, '2024-04-29 13:40:59'),
(15, 3, 3, 3, '2024-04-29 13:40:59'),
(16, 4, 4, 1, '2024-04-29 13:40:59'),
(17, 6, 5, 3, '2024-04-29 13:40:59');



CREATE TABLE `student_course_registration` (
`id` int NOT NULL AUTO_INCREMENT,
`student_id` int NOT NULL,
`course_wise_teacher_id` int NOT NULL,
`marks` double(4,2) NOT NULL,
`grade` double(3,2) NOT NULL,
`created_at` datetime DEFAULT NULL,
`updated_at` datetime DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `student_id` (`student_id`),
KEY `course_wise_teacher_id` (`course_wise_teacher_id`),
CONSTRAINT `student_course_registration_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
CONSTRAINT `student_course_registration_ibfk_3` FOREIGN KEY (`course_wise_teacher_id`) REFERENCES
`course_wise_teacher` (`id`)
);
select *from student_course_registration;
INSERT INTO `student_course_registration`
(`id`, `student_id`, `course_wise_teacher_id`, `marks`, `grade`, `updated_at`)
VALUES
(1, 2, 1, 80.00, 4.00, '2024-04-30 14:30:11'),
(2, 2, 2, 75.00, 3.75,  '2024-04-30 14:30:11'),
(3, 2, 3, 65.00, 3.25,  '2024-04-30 14:30:11'),
(4, 2, 4, 78.00, 3.75,  '2024-04-30 14:30:11'),
(5, 1, 2, 85.00, 4.00,  '2024-04-30 14:30:11'),
(6, 1, 4, 39.00, 0.00,  '2024-04-30 14:30:11'),
(7, 1, 6, 20.00, 0.00,  '2024-04-30 14:30:11'),
(12, 12, 15, 79.00, 3.25,  '2024-04-30 14:30:11'),
(26, 3, 10, 70.00, 2.70,  '2024-04-30 14:30:11'),
(27, 4, 13, 65.00, 2.30,  '2024-04-30 14:30:11'),
(28, 5, 13, 89.00, 3.70,  '2024-04-30 14:30:11'),
(29, 6, 14, 89.00, 3.70,  '2024-04-30 14:30:11'),
(30, 7, 16, 56.00, 1.70,  '2024-04-30 14:30:11'),
(31, 1, 11, 76.00, 2.75,  '2024-04-30 14:30:11'),
(32, 8, 17, 49.00, 2.75,  '2024-04-30 14:30:11'),
(33, 10, 15, 79.00, 3.25,  '2024-04-30 14:30:11'),
(34, 12, 12, 63.00, 3.25,  '2024-04-30 14:30:11'),
(35, 2, 12, 78.00, 3.25,  '2024-04-30 14:30:11'),
(36, 2, 10, 58.00, 2.25,  '2024-04-30 14:30:11'),
(37, 13, 13, 68.00, 2.25,  '2024-04-30 14:30:11'),
(38, 13, 15, 38.00, 0.00,  '2024-04-30 14:30:11');

/*Query 1 Answer:*/

SELECT * FROM teachers
WHERE address = 'Dhaka';

SELECT name, email
FROM students;



SELECT gender, COUNT(*) AS students
FROM students
GROUP BY gender;


****
**Task Solve-Answer No 1**

```sql
SELECT teacher_id, COUNT(course_id) AS totalAssignedCourses
FROM course_wise_teacher
GROUP BY teacher_id;
```




/*Answer No 2*/
SELECT name,substr(name,1, 5) AS firstFiveCharatersName
FROM courses;


/*Answer No 3*/
SELECT gender, GROUP_CONCAT(id separator ';') AS concatenatedTeacherIdList
FROM teachers
GROUP BY gender;

/*Answer no 4*/
SELECT name
FROM students
WHERE LENGTH(name) > 10;

/*Answer No 5*/
SELECT (SELECT name FROM courses ORDER BY LENGTH(name) DESC LIMIT 1) AS longestCourseName,
(SELECT name FROM courses ORDER BY LENGTH(name) ASC LIMIT 1)  AS shortestCourseName;


/*Answer No 06*/
SELECT student_id,
(select name from students where id  = student_id) as studentName,
SUM(marks) AS totalMarks,
AVG(marks) AS averageMarks
FROM student_course_registration
GROUP BY student_id;

/*Answer No 07*/
SELECT student_id,
SUM(marks) AS totalMarks,
COUNT(course_wise_teacher_id) AS numberOfCourses
FROM student_course_registration
WHERE marks > 70
GROUP BY student_id;

/*Answer no 8*/
SELECT student_id,
(select course_id from course_wise_teacher
where course_wise_teacher.id = course_wise_teacher_id) as courseId,
marks,
CASE
WHEN marks >= 90 THEN 'Excellent'
WHEN marks BETWEEN 70 AND 89 THEN 'Good'
WHEN marks BETWEEN 50 AND 69 THEN 'Average'
ELSE 'Poor'
END
AS category
FROM student_course_registration;




















