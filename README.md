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






