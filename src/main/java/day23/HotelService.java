package day23;

import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private List<Hotel> hotels;
    public HotelService(){
        hotels=JsonReaderUtil.loadHotelData();
    }

    public void showHotels(){
        for(Hotel hotel:hotels)
        {
            System.out.println(hotel);
        }
    }

    public void show5StarHotel() {
        List<Hotel> hotel5star=new ArrayList<>();
        for(Hotel hotel:hotels){
            if(hotel.getType() == HotelType.FIVE_STAR)
            {
                hotel5star.add(hotel);
            }
        }
        System.out.println(hotel5star);
    }

    public List<Hotel> filterHotel(HotelFilter hotelFilter){
        List<Hotel> filterlist=new ArrayList<>();
        for(Hotel hotel: hotels){
            if(hotelFilter.test(hotel))
            {
                filterlist.add(hotel);
            }
        }
        return filterlist;
    }
     /*public List<Hotel> getHotels(HotelType hotelType) {
        List<Hotel> hotel5StarList = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getType() == hotelType) {
                hotel5StarList.add(hotel);
            }
        }
        return hotel5StarList;
    }

    public List<Hotel> getHotels(String city) {
        List<Hotel> filteredByCityList = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getCity().equalsIgnoreCase(city)) {
                filteredByCityList.add(hotel);
            }
        }
        return filteredByCityList;
    }

    public List<Hotel> getHotels(HotelType hotelType, String city) {
        List<Hotel> filteredByCityAndTypeList = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getCity().equalsIgnoreCase(city) && hotel.getType() == hotelType) {
                filteredByCityAndTypeList.add(hotel);
            }
        }
        return filteredByCityAndTypeList;
    }

    public List<Hotel> getHotels(float rating) {
        List<Hotel> filteredByRatingList = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getRating() >= rating) {
                filteredByRatingList.add(hotel);
            }
        }
        return filteredByRatingList;
    }*/

}
