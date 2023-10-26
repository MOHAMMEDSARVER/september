package day22;

//What is Functional interfaca: => An Interface with only one abstract method is called functional interface
//it can have any no.of default or private or static methods but the abstract mehtod must be only one
//What is the use of Functional inerface?:=> the fucntionalinterfaces are used for lambda functions
@FunctionalInterface
interface I1 {
    //here it has only one abstract method so this is a functional interface
    void m1();

    //this below code is default method which is introduced in java 8 version. we cas use default method only in
    //interfaces and we can write implementation of that method in interface
    //we can even write private and static mehods in interface , which is introduced in java 8
    default void m2() {
        System.out.println("I1 m2");

    }
}

//interface withour any abstract method is called marker interface. so I2 is marker interface
interface I2 {

}

@FunctionalInterface
interface Operator {
    int perform(int a, int b);
}

//Non Static inner Class : Outer class variable can use in inner class
class Outer {
    int a = 20;
    class Inner {
        void show() {
            System.out.println(a);
        }
    }
}

//below code is static inner class : inner class will be static
class Outer1 {
    static int a = 10;
    static class Inner1 {
        void show() {
            System.out.println(a);
        }
    }
}

//Local Inner Class: in outer class method we will define another class and obj call method
class Outer2 {
    int a = 10;
    void show() {
        class Inner2 {
            void show() {
                System.out.println(a);
            }
        }
        Inner2 obj = new Inner2();
        obj.show();
    }
}


public class FunctionalInterfaceExample {
    //Inner Classes: there are 4 types
    // def: in java 8 we can create a lass within another class that concept is called inner calsses
    //1: Non Static inner Class :
    //2: Static Inner cllas
    //3: Local Inner Class
    //4: Anonymous Inner Class

    public static void main(String[] args) {
        Operator obj = (int a, int b) -> a + b;//lamda Expression
        System.out.println(obj.perform(11, 20));
    }
}
