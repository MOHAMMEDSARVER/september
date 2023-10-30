package day22;
interface One{
    void m1();
}
interface  Two{
    void m2();
}
interface Three{
    void m1();
    void m2();
    void m3();

}
interface Four extends One,Two,Three{
    //an Interface can extend any number of interfaces
    //but a class can implement any numbe of interfaces
}

interface Five{
    String toString();
    //here we are using Object Class method toString so we should be very case full
    //about there return type and all if we are using any parent class methods
    //in this case toString() of Object class  will return Sting object so return type here will be string

}
class ClS2 implements Five{
    public String toString(){
        return" ";
    }

}
class CLS1 implements Four{

    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }
}
public class InterfaceExample {

}
