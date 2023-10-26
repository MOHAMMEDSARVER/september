package day23;

import java.util.List;

public class HotelManager {
    public static void main(String[] args) {
        HotelService service = new HotelService();
        service.showHotels();
        System.out.println("-----------------------------------------------------------------------------");
        service.show5StarHotel();
        System.out.println("2 star _______________________________________________________________");
        List<Hotel> li = service.filterHotel(new HotelFilter() {
            @Override
            public boolean test(Hotel hotel) {
                if (hotel.getCity().equals("Bangalore"))
                    return true;
                return false;
            }
        });
        System.out.println(li);
        System.out.println("------------------------------------lambda Functions__________________________");
        List<Hotel> list5star = service.filterHotel(hotel -> hotel.getType() == HotelType.FIVE_STAR);

        System.out.println(list5star);
        // 2. Find all hotels rating greater than or equal to 4.5
        System.out.println("------------------------4.5 rating hotels---------------------");
        List<Hotel> list45 = service.filterHotel(hotel -> hotel.getRating() >= 4.5);
        System.out.println(list45);

        // java8 lambda expression

        // () -> {}
        // (a) ->  a * a;
        // (a,b) -> {
        //      sop(a);
        //      sop(b);
        //      return a + b;
        // }
        System.out.println("-----------------------Taj Hotel_______________");
        List<Hotel> tajhotel=service.filterHotel(hotel -> hotel.getName().equals("Taj"));
        System.out.println(tajhotel);

    }
}
