//gayathti.p
//2117240070087
program title:class"car" with methods
  TEST CASE 1:
public class Car {
String model;
String color;
Car(String model, String color){
    this.model=model;
    this.color=color;
    }
void start() {
    if(model!=null&&!model.isEmpty()) {
        System.out.println("Car Started");
    }else {
        System.out.println("Car started(but model not shown)");
    }
}
void stop() {
    System.out.println("Car Stopped");
}
public static void main(String[] args) {
    Car car1= new Car("Tesla","Red");
    car1.start();
    }
}

OUTPUT:
Car started 

  TEST CASE 2:
public class Car {
String model;
String color;
Car(String model, String color){
    this.model=model;
    this.color=color;
    }
void start() {
    if(model!=null&&!model.isEmpty()) {
        System.out.println("Car Started");
    }else {
        System.out.println("Car started(but model not shown)");
    }
}
void stop() {
    System.out.println("Car Stopped");
}
public static void main(String[] args) {
    Car car2= new Car("BMW","black");
    car2.start();
    }
}

OUTPUT:
Car started



TEST CASE 3:
public class Car {
String model;
String color;
Car(String model, String color){
    this.model=model;
    this.color=color;
    }
void start() {
    if(model!=null&&!model.isEmpty()) {
        System.out.println("Car Started");
    }else {
        System.out.println("Car started(but model not shown)");
    }
}
void stop() {
    System.out.println("Car Stopped");
}
public static void main(String[] args) {
    Car car3= new Car("Red");
    car3.start();
    }
}
OUTPUT:
Car started(but model not shown)


TEST CASE 4:
public class Car {
String model;
String color;
Car(String model, String color){
    this.model=model;
    this.color=color;
    }
void start() {
    if(model!=null&&!model.isEmpty()) {
        System.out.println("Car Started");
    }else {
        System.out.println("Car started(but model not shown)");
    }
}
void stop() {
    System.out.println("Car Stopped");
}
public static void main(String[] args) {
    Car car4= new Car("audi","white");
    car4.start();
    }
}
OUTPUT:
Nothing



TEST CASE 5:
public class Car {
String model;
String color;
Car(String model, String color){
    this.model=model;
    this.color=color;
    }
void start() {
    if(model!=null&&!model.isEmpty()) {
        System.out.println("Car Started");
    }else {
        System.out.println("Car started(but model not shown)");
    }
}
void stop() {
    System.out.println("Car Stopped");
}
public static void main(String[] args) {
    Car car5= new Car("ford","grey");
    car5.start();
    }
}
OUTPUT:
Car stopped



