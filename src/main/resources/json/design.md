❓ What % of your work time is spend writing new code?
> • 10-15% • 15-40% • 40-80% • > 80%
>
⏱ Where does the rest of the time go?
- Looking up documentation / stackoverflow
- Testing
- Debugging
- Review existing code
- Refactoring
- Regression
- Meetings
- AFK (sleeping)
- Chai Coffee 
- Netflix / Phone
- TT
- Upskilling

✅ Goals
--------
We'd like to make our code
1. Extensible
2. Readable
3. Testable
4. Maintainable
####  Robert C. Martin - Uncle Bob
-------------------
💎 SOLID Principles
-------------------
- Single Responsibility
- Open Close
- Liskov's Substitution
- Interface Segregation
- Dependency Inversion
Dependency Inversion =/= Dependency Injection =/= Inversion of Control

💭 Context
----------
- Zoo Game 🦊
- Model the various characters in code
--------------------------------------------------------------------------

```java
class Animal{

    // attributes[properties]
     double weight;
     String color;
     String species;
     int numberOfLegs;
     boolean hasWings;
     boolean hasFins;
     boolean hasGills;
     // behavior[methods]
     void fly() {}
     void eat() {}
     void swim() {}
     void breatheUnderWater() {}
     void breahteOnLand() {}

}
```

🐠 Animals have varied behavior

```java
class Animal {
     /* ... */
     void swim() {
     String output = "Swim Tuna swim";
     if(species == "Tuna" || species == "Shark")
     print(output);
     else if(species == "Pigeon" || species == "Cheetah")
     print("Do I look like a fish to you?");
     else if(species == "Peacock") print("");

    }
}
```

🐞 Problems with the above code?
If we have 100 different species, then we will need 100 different if-else
conditions, or even more
So what? What is bad in having a lot of if-else cases?
❓ Readable
 I can read it? But if we have many species, it will quickly become too
difficult to read
❓ Testable
 Certainly? But changing code for 1 species will affect code for other
species. Difficult to test.
❓ Extensible
 Yes, I can add more if-elses? Not extensible, because adding a new feature
requires changes in the code of existing features
❓ Maintainable
 If multiple devs are working on different species, then they will encounter
Merge Conflicts!

🛠 How to fix this?
Try to Segregate the Responsibilities.
----------------------------------
⭐ Single Responsibility Principle
----------------------------------
- Every function/class/module should have a single, well-defined responsibility.
- If some class is serving multiple responsibilities, split it into multiple
classes.

```java
abstract class Animal {
 double weight;
 String color;
 String species;
 void eat();
}
class Bird extends Animal {
 void fly() {}
 void run() {}
 void breatheOnLand() {}
}
class Fish extends Animal {
 void swim() {}
 void breatheUnderWater() {}
}
class Mammal extends Animal {
 int numberOfLegs;
 void run() {}
 void breahteOnLand() {}
}
class Reptile extends Animal {
 void crawl() {}
 void breahteOnLand() {}
}
```

- Readable
 Yes. Even though we might have a lot of code, each piece of code in itself is
easily readable and understandable.
- Testable
 Yes. Changes to `Fish.swim()` do NOT effect `Bird.fly()`
- Extensible
 Yes. To add a new species, I simply need to create a new subclass.
- Maintainable
 Kindof. Reduced merge conflicts.
❔ If there are a 100 different species, we will have to implement 100 different
classes?

#### 📜 Rules vs Guidelines
1. Don't commit murder [Rule - it is enforced - must be followed]
2. Don't run on a wet floor [Guideline - optional to follow]
SOLID principles are Guidelines, and not rules.
--------------------------------------------------------------------------



🐦 Design a Bird
----------------
```java
class Bird extends Animal {
 String species; // inherited from Animal
 void fly() {}
 // ...
}
```
🕊 Different birds fly differently
```java
//[library] Zoo {
     class Bird extends Animal {
     String species; // inherited from Animal
     void fly() {
     if (species == "sparrow")
     print("fly low");
     else if (species == "Eagle")
     print("Glide elegantly");
     else if (species == "Pigeon")
     print("Flap vigourously");
     else if()
     }
     }
//}
//[executable] Client {
 // can I add a new Bird species here?
 // I Cannot !!
     class Main {
     void main() {
     }
     }
//}
```
🐞 Problems with the above code?
- Readable
 No.
- Testable
 No.
- Extensible
 No.
- Maintainable
 No.
 
 🛠 How to fix this?
 Avoid modification of existing code, unless absolutely necessary
 -----------------------
 ⭐ Open Close principle
 -----------------------
 - Your code should be closed for modification, yet open for extension!
 Why is modification bad?
  Dev - Write code. Test it yourself
  QA team - test, integration tests
  Deployed
  + A/B testing (5% of users)
  + final deployent to 100% users will happen


```java
//[library] Zoo {
 abstract class Bird extends Animal {
 abstract void fly() {}
 }
 class Sparrow extends Bird {
 @Override
 void fly() { print("Fly low"); }
 }
 class Eagle extends Bird {
 @Override
 void fly() { print("Glide elegantly"); }
 }
//}

//[Executable] Client{ 
 //can I add a new species of Bird?
 //Yes!
 //import  Zoo.Bird;
 class Peacock extends Bird {
 
 }
 class Main {
 void main() {
 }
 }
//}
```

- Modification. Yes
- Extension
 If someone is using your code as a library (they don't have access to the
source code of your library) can they still extend the code?
 Yes.
- Readable. Yes
- Testable. Yes
- Extensible. Yes
- Maintainable. Yes
❔ Didn't we make the exact same changes to adhere to the Single Responsibility
principle as well?
Is Single Responsibility = Open Close? No.
🔗 The SOLID principles are linked to each other.
analogy: If you speak the truth, then you're honest. If you're honest, you speak
the truth.

[----------------------------------------------------------------------------------------------]

🐓 Can all birds fly?
---------------------
```java
 abstract class Bird extends Animal {
 abstract void fly() {}
 }
 class Kiwi extends Bird {
 @Override
 void fly() {
 // a Kiwi can't fly
 }
 }
```
Penguin, Kiwi, Ostrich, Dodo, Emu ... are birds which cannot fly!

[------------------Quetion - 1-----------------]
❓ How do we solve this?
>
> • Throw exception with a proper message
> • Don't implement the `fly()` method
> • Return `null`
> • Redesign the system
>
 Don't implement
```java
 abstract class Bird extends Animal {
 abstract void fly() {}
 }
 class Kiwi extends Bird {
 // don't imeplement the fly() method
 }
```
🐞 The compiler will complain - a concrete class must implement all method of
the parent abstract class


⚠️ Throw an exception
```java
 abstract class Bird extends Animal {
 abstract void fly() {}
 }
 class Kiwi extends Bird {
 @Override
 void fly() {
 throw new CantFlyException("I'm a Kiwi dude (-_-)");
 }
 }
```
🐞 This violates expectations!

```java
//[executable] Client {
 class Main {
 void main() {
 Bird b;
 b = getBirdFromUserInput(); // might return sparrow, eagle, kiwi
 b.fly();
 }
 }
//}
```

✅ Before extension
Code was working fine.
❌ After extension
Code fails at random points. No longer working fine for some scenarios.
If we extend working code, the old features should not break!

[--------------------------------------------------------------------------]
--------------------------------
⭐ Liskov Substitution principle
--------------------------------
- Any functionality in the parent class must also work for child classes.
- If some piece of code works with a parent `class P`, it should work,
unmodified, with all child `class C extends P`
- Any extension to existing code should not break existing features
🎨 How should we re-design it?


```java
abstract class Bird extends Animal {
 String numberOfWings;
 boolean hasBeak;
 void speak();
 // no void fly() inside Bird
}
interface ICanFly {
 void fly();
}
class Eagle extends Bird implements ICanFly {
 @Override
 void fly() { print("Glide elegantly"); }
}
class Kiwi extends Bird {
 // no need to implement the void fly()
}
```

Can it fly?
-----------
- Flap wings
- Kick off the ground to take off
```java
interface ICanFly {
 void fly();
 // what other things do flying birds do?
 void flapWings();
 void kickOffGroundToTakeOff();
}
class Eagle extends Bird implements ICanFly {
 @Override
 void fly() { /* ... */ }
 @Override
 void flapWings() { /* ... */ }
 @Override
 void kickOffGroundToTakeOff() { /* ... */ }
}
```
> Question 2
> ❓ Should these additional methods be part of the ICanFly interface?
>
> • Yes, obviously. All things methods are related to flying
> • Nope. [send your reason in the chat]
> 
```java
interface ICanFly {
 void fly();
 void flapWings();
 void kickToTakeOff();
}

class Eagle extends Bird implements ICanFly {
 /* ... */
}
// what other things apart from Bird can fly?
class Airplane extends Vehicle implements ICanFly {
 @Override
 void flapWings() {
 // wtf!?
 }
}
class Shaktiman implements ICanFly {
 @Override
 void flapWings() {
 print("Sorry Shaktiman");
 }
}
class MomChappal implements ICanFly {
 ...
}
```
----------------------------------
⭐ Interface Segregation Principle
----------------------------------
- Keep your intefaces minimal
- No code should be forced to implement a method that it does not need
To fix previous code, we can simply split the `ICanFly` interface into multiple
interfaces
🔗 This is simply the SRP applied to interfaces?

[---------------------------------------------------------------------------------------]
Now that we've the necessary characters, let's design the structures.
Design a Bird Cage
------------------


```java

interface IFeedingBowl {}
class MeatFeedingBowl implements IFeedingBowl {}
class FruitFeedingBowl implements IFeedingBowl {}

interface IBars {}
class WoodenBars implements IBars {}
class IronBars implements IBars {}
class SmallGapBars implements IBars {}

class Cage1 {
 MeatFeedingBowl feedingBowl;
 IronBars bars;
 List<Tiger> tigers;
 public Cage1() {
 // add 5 tigers
 for(int i = 0; i < 5; i++)
 tigers.add(new Tiger(...));
 }
}
class Cage2 {
 FruitFeedingBowl feedingBowl;
 WoodenBars bars;
 List<Birds> henAndPeackock;
 public Cage2() {
 // add 10 hen
 for(int i = 0; i < 10; i++)
 henAndPeackock.add(new Hen(...));
 // add 3 peacocks
 for(int i = 0; i < 3; i++)
 henAndPeackock.add(new Peacock(...));
 }
}
```

🐞 What is wrong with this code?
We have to create many different types of Cage classes.
No resue of the cage class.

High-Level class `Cage1` depends on concrete types `MeatFeedingBowl`, `Tiger`
and `IronBars`
---------------------------------
⭐ Dependency Inversion Principle
---------------------------------
- High-level modules should NOT depend on low-level modules.
- Instead, they should depend on Abstractions (interfaces)


But how?
-----------------------
💉 Dependency Injection
-----------------------
- Instead of creating dependencies, inject them


```java
class Cage {
 IFeedingBowl feedingBowl;
 IBars bars;
 List<Animal> animals;
 public Cage(IFeedingBowl feedingBowl,
 IBars bars,
 List<Animal> animals) {
 this.feedingBowl = feedingBowl;
 this.bars = bars;
 // don't forget to make a copy here
 this.animals.addAll(animals); // python: animals[:]
 }
}
class Main {
 void main() {
 Cage cage1 = new Cage(new MeatFeedingBowl(),
 new IronBars(),
 Arrays.toList(new Tiger(), ...));
 Cage cage1 = new Cage(new FruitFeedingBowl(),
 new woodenBars(),
 Arrays.toList(new Peacock(), ...));
 }
}
```

[--------------Example------------------]

---------------------
🏛 HR Management Tool
---------------------
1. System should support different types of employees
 Fulltime / Intern / Contractual

2. Provide a save() method
 Save the employee object in a file, in the format the is specific by the HR


```java
public abstract class Employee {
 private String firstName;
 private String lastName;
 private int monthlyIncome;
 private int hoursPerWeek;
 public Employee(String fullName, int monthlyIncome){
 setMonthlyIncome(monthlyIncome);
 String[] names = fullName.split(" ");
 this.firstName = names[0];
 if(names.length > 1)
 this.lastName = names[1];
 }
 // getters & setters for properties

public static void save(Employee employee){
 try {
 StringBuilder sb = new StringBuilder();
 sb.append("### EMPLOYEE RECORD ####");
 sb.append(System.lineSeparator());
 sb.append("NAME: ");
 sb.append(employee.firstName + " " + employee.lastName);
 sb.append(System.lineSeparator());
 sb.append("POSITION: ");
 sb.append(employee.getClass().getTypeName());
 sb.append(System.lineSeparator());
 sb.append("EMAIL: ");
 sb.append(employee.getEmail());
 sb.append(System.lineSeparator());
 sb.append("MONTHLY WAGE: ");
 sb.append(employee.monthlyIncome);
 sb.append(System.lineSeparator());
 Path path = Paths.get(employee.getFullName()
 .replace(" ","_") + ".rec");
 Files.write(path, sb.toString().getBytes());
 System.out.println("Saved employee " + employee.toString());
 } catch (IOException e){
 System.out.println("ERROR: Could not save employee. " + e);
 }
 }
}
```


❓ Which SOLID principle does the above code violate?
>
> • SRP
> • Open Close
> • Liskov Substitution
> • Interface Segregation
> • Dependency Inversion
>
Violates the Single Responsibility principle
❔ What responsibilities can we identify here
1. Serialzing the Employee object in the format specified by the HR
2. Saving the serialized object into a file
3. Logging


Anticipatory changes
--------------------
- HR prefers a different format for serialization
 will have to change Employee class
- Switch from file-based storage to database
 will have to change Employee class
- Improved logging
 will have to change Employee class
 
Responsibilities of Employee class
----------------------------------
❔ Should the Employee class be responsible for
1. maintaining the preferences of the HR?
 No.
2. handling interaction with the storage system?
 No.
3. handling how the logging is done?
 No.
 
 
❔ What should the Employee class really be responsible for?
1. To store the attributes & behaviour of the Employee


----------------------------
✨ Adding Functionality - v2
----------------------------


Feature request: add functionality to calculate Income Tax for Employee
>
> ❓ Where should the code for calculating Income Tax reside?
>
> • Employee class, since we're calculating tax for employee
>
> • New class, to follow the SRP
>
❔ Why should the Income Tax calculation be inside Employee class?
Because it needs to know employee details like salary, name, et cetera
❔ Why should the Income Tax calculation NOT be inside Employee class?
Because it needs to know the rules for tax calculation


Anticipatory Changes
--------------------
 updated rules for tax calculation: GST / SBC
🗳 tax reduction before election year
```java
class TaxCalculator {
 /* inject dependency */
 double calculateTax(Employee employee) {
 // dependency on the Employee
 }
}
```

Complex Changes
---------------
 Full time Employee 30% Income Tax
 2% SBC
 2% KWN
👶 Intern 10% Income Tax
```java
interface ITaxCalculationStrategy {
 double calculateTax(Employee employee);
}
class Tax2020Strategy implements ITaxCalculationStrategy {
 double calculateTax(Employee employee) {
 // no tax in 2020 because of covid
 }
}


/* ---------------------- Bad Code ----------------------*/
class Tax2021Strategy implements ITaxCalculationStrategy {
 double calculateTax(Employee employee) {
 if(employee.isFullTime())
 ...
 else if(employee.isIntern())
 ...
 }
}
/* ------------------------------------------------------*/
class Tax2021StrategyForInterns implements ITaxCalculationStrategy {
 ...
}
class Tax2021StrategyForFullTime implements ITaxCalculationStrategy {
 ...
}

// how will we decide which class to use to calculate tax with?
// use Factory design pattern!
class TaxStrategyFactory {
 List<String, ITaxCalculationStrategy> strategyMapping;
 private TaxStrategyFactory() {
 // load the mapping from database
 }
 public TaxStrategyFactory getInstance() {
 // double check to make thread safe
 return new TaxStrategyFactory();
 }
 ITaxCalculationStrategy getStrategy(Employee employee) {
 // load some config from the database
 // return the appropriate strategy for the employee
 }
}

class Main {
 void main() {
 Employee employee;
 TaxStrategyFactory.getInstance()
 .getStrategy(employee);
 .calculateTax(employee);
 }
}
// new requirement: Add a new type of employee
// Contractual Employee
class Tax2021StrategyForContractual implements ITaxCalculationStrategy {
 ...
}
// update the database config values
```
❔ If tomorrow the government says that the rules are same for everyone, which
changes need to be made?
• Add a new class `TaxStrategy2023`
• Update the config in the db
• Absolutely 0 change in existing code


----------------------------
✨ Adding Functionality - v3
----------------------------
Feature request: Process the payment for employees
Different employees have different perks
```java
abstract class Employee {
 abstract void processPayment();
}
class FullTimeEmployee extends Employee {
 @Override
 void processPayment() {
 // base pay
 // HRA
 // health insurance
 // bonus
 }
}
class ContractualEmployee extends Employee {
 @Override
 void processPayment() {
 // base pay
 }
}
class Volunteer extends Employee {
 @Override
 void processPayment() {
 !?
 }
}
```

❓ Which SOLID principle does the above code violate?
>
> • SRP
> • Open Close
> • Liskov Substitution
> • Interface Segregation
> • Dependency Inversion
>
violates the Liskov Substitution principle


```java
abstract class Employee {
 // no processPayment here
}
interface IAmPaid {
 void processPayment();
}
class FullTimeEmployee extends Employee implements IAmPaid {
 @Override
 void processPayment() { ... }
}
class ContractualEmployee extends Employee implements IAmPaid {
 @Override
 void processPayment() { ... }
}
class Volunteer extends Employee {
 // no longer need to implement processPayment() since they don't implement
IAmPaid
}
```

----------------------------
✨ Adding Functionality - v4
----------------------------
Feature request: Load the employee results from the database
```java
class EmployeeLoader {
 Employee loadEmployee(Long employeeId) {
 SQLConnection conn = SQLConnection.getInstance();

 // caution: make sure there is no chance of SQL injection here
 List<List<String>> rows = conn.executeQuery(
 "select * from employees where id = ?", employeeId
 )
 if(rows.length == 0)
 throw new NoSuchEmployeeException(employeeId);
 return InternDeserializer.getInstance()
 .deserialize(rows[0]);
 }
}
```

❓ Which SOLID principle does the above code violate?
>
> • SRP
> • Open Close
> • Liskov Substitution
> • Interface Segregation
> • Dependency Inversion
>
violates Dependency Inversion principle


```java
interface IDBConnection {
 List<List<String>> executeQuery(String query, String args...);
}
class SQLConnection implements IDBConnection { ... }
class MongoDBConnection implements IDBConnection { ... }
interface IEmployeeDeserializer {
 Employee deserialize(List<String> record);
}
class InternDeserializer implements IEmployeeDeserializer { ... }
class FulltimeEmployeeDeserializer implements IEmployeeDeserializer { ... }
class EmployeeDeserializerFactory {
 // singleton
 IEmployeeDeserializer getDeserializer(String type) {
 ...
 }
class EmployeeLoader {
 IDBConnection conn;
 public EmployeeLoader(IDBConnection conn) {
 this.conn = conn;
 }
 Employee loadEmployee(Long employeeId) {
 // we need to get employee record from database
 List<List<String>> rows = conn.executeQuery(...)

 if(rows.length == 0)
 throw new NoSuchEmployeeException(employeeId);
 List<String> record = rows[0];
 return EmployeeDeserializerFactory
 .getInstance()
.getDeserializer(record[0])
 .deserialize(record);
 }
}
```

Enterprise style code.


