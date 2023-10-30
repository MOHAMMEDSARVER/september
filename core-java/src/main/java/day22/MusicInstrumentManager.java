package day22;

import java.util.Scanner;

interface MusicInstrument{
    String brandName="Yamaha";//public static final string brand name
    void soung();//public abstract void sound
}
class Violin implements MusicInstrument{

    @Override
    public void soung() {
        System.out.println("Piano playing");
    }
}
class Guitar implements MusicInstrument{

    @Override
    public void soung() {
        System.out.println("Guitar is playing");
    }
}
class Piano implements MusicInstrument{

    @Override
    public void soung() {
        System.out.println("Piano is playing");
    }
}
class Flute implements MusicInstrument{

    @Override
    public void soung() {
        System.out.println("Flute is playing");
    }
}
public class MusicInstrumentManager {
    public static void main(String[] args) {
        MusicInstrument ref= getMusicalInstrument();
        ref.soung();
    }

    private static MusicInstrument getMusicalInstrument() {
        System.out.println("1.Piano 2.Guitar 3.Flute 4.Violin");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
       MusicInstrument instrumentObj = switch (ch)
        {
            case 1 -> new Piano();
            case 2 -> new Guitar();
            case 3 -> new Flute();
            case 4 -> new Violin();
            default -> throw new IllegalArgumentException("Unexpexted Value "+ch);
        };
        return instrumentObj;
    }
}
