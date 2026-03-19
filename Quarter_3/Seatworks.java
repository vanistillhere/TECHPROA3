package Quarter_3;
import java.util.*;

public class Seatworks {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many grades? ");
        int numgrades = scanner.nextInt();

        double sum = 0;
        for (int i = 1; i <= numgrades; i++) {
            System.out.print("Enter grade " + i + ": ");
            sum += scanner.nextInt();
        }

        double average = sum / numgrades;
        System.out.println("Average: " + average);

        char lettergrade;
        if (average >= 90) lettergrade = 'A';
        else if (average >= 80) lettergrade = 'B';
        else if (average >= 70) lettergrade = 'C';
        else if (average >= 60) lettergrade = 'D';
        else lettergrade = 'F';

        System.out.println("Letter grade: " + lettergrade);

        Car mycar = new Car();
        mycar.honk();
        System.out.println(mycar.brand + " " + mycar.modelname);

        Studentinfo s = new Studentinfo();
        s.setname("Miguel Santino Gandeza");
        s.setage(16);
        s.setcourse("ICT");
        s.displayinfo();

        Dog dog = new Dog();
        dog.setname("Doggy");
        dog.sound();
        dog.sound(2);

        Paymentprocessor p = new Paymentprocessor();
        p.processpayment(100, "ETH");
        p.processpayment(200, "USD", "GCash");

        Areacalculator calc = new Areacalculator();
        System.out.println("Square: " + calc.calculatearea(5));
        System.out.println("Rectangle: " + calc.calculatearea(4, 6));

        Bankaccount savings = new Savingsaccount("SAV-1", 1000);
        savings.displayaccountinfo();
        savings.calculateinterest();

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }

        try {
            Passwordchecker.checkpassword("zta99");
        } catch (Passwordexception e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Studentrecord> students = new ArrayList<>();
        students.add(new Studentrecord(1, "Juan"));
        students.add(new Studentrecord(2, "Maria"));

        for (Studentrecord st : students) {
            st.displayinfo();
        }

        students = null;
        System.gc();

        scanner.close();
    }
}

class Vehicle {
    protected String brand = "Ford";
    void honk() {
        System.out.println("Tuut, tuut!");
    }
}

class Car extends Vehicle {
    String modelname = "Mustang";
}

class Person {
    private String name;
    private int age;

    public void setname(String name) { this.name = name; }

    public void setage(int age) {
        this.age = (age > 0) ? age : 0;
    }

    public String getname() { return name; }
    public int getage() { return age; }
}

class Studentinfo extends Person {
    private String course;

    public void setcourse(String course) { this.course = course; }

    public void displayinfo() {
        System.out.println("Name: " + getname());
        System.out.println("Age: " + getage());
        System.out.println("Course: " + course);
    }
}

class Animal {
    private String name;

    public void setname(String name) { this.name = name; }
    public String getname() { return name; }

    void sound() {
        System.out.println("Animal sound");
    }

    void sound(int times) {
        for (int i = 0; i < times; i++) sound();
    }
}

class Dog extends Animal {
    void sound() { System.out.println("Bark!"); }
}

class Paymentprocessor {
    void processpayment(double amount, String currency) {
        System.out.println("Processing " + amount + " " + currency);
    }

    void processpayment(double amount, String currency, String method) {
        System.out.println("Processing " + amount + " " + currency + " via " + method);
    }
}

class Areacalculator {
    int calculatearea(int side) { return side * side; }
    double calculatearea(double l, double w) { return l * w; }
}

abstract class Bankaccount {
    private String acc;
    private double balance;

    Bankaccount(String acc, double bal) {
        this.acc = acc;
        this.balance = bal;
    }

    abstract void calculateinterest();

    double getbalance() { return balance; }

    void deposit(double amt) { balance += amt; }

    void displayaccountinfo() {
        System.out.println("Account: " + acc + " Balance: " + balance);
    }
}

class Savingsaccount extends Bankaccount {
    Savingsaccount(String acc, double bal) {
        super(acc, bal);
    }

    void calculateinterest() {
        deposit(getbalance() * 0.05);
        System.out.println("Interest added!");
    }
}

class Passwordexception extends Exception {
    Passwordexception(String msg) { super(msg); }
}

class Passwordchecker {
    static void checkpassword(String password) throws Passwordexception {
        if (!password.equals("zta99"))
            throw new Passwordexception("Wrong password");
        System.out.println("Access granted");
    }
}

class Studentrecord {
    int id;
    String name;

    Studentrecord(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void displayinfo() {
        System.out.println(id + " - " + name);
    }
}