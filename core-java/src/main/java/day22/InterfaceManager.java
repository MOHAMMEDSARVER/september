package day22;

import java.util.List;

interface Game{
    void start();
    void play();
    void stop();
}
abstract class AbstractGame implements Game{
    @Override
    public void start()
    {
        System.out.println(this.getClass().getSimpleName()+" is Started");
    }

    @Override
    public void stop() {
        System.out.println(this.getClass().getSimpleName()+ " is Stopped");
    }
}

class Car extends AbstractGame implements Game{
    @Override
    public void play()
    {
        System.out.println("You are playing game "+this.getClass().getSimpleName()+" please wear seatbelt");
    }
}
class Bike extends AbstractGame implements Game{
    @Override
    public void play() {
        System.out.println("You are playing game "+this.getClass().getSimpleName()+" Please wear hemet");
    }
}
class Ship extends AbstractGame implements Game{
    @Override
    public void play() {
        System.out.println("You are playing game "+this.getClass().getSimpleName()+" please wear life jacket");
    }
}
public class InterfaceManager {
    public static void main(String[] args) {
        List<Game> game=List.of(new Car(),new Ship(),new Bike(),new Car(),new Ship(),new Bike(),new Car(),new Ship(),new Bike());
        for(Game g:game)
        {
            g.start();
            g.play();
            g.stop();
            System.out.println("--------------------------------------------------------------");
        }
    }
}
