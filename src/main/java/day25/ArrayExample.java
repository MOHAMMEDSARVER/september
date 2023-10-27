package day25;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

record Hotel(String name, String type, double pricePerNight, double rating, String city) {

}


public class ArrayExample {

    public static void main(String[] args) {
        List<Hotel> hotels = getHotelDetails();
        System.out.println(getHotelsRatingGt(2));
    }

    private static List<String> getHotelsRatingGt(double rating) {
        // TODO : Return the list of hotel names whose rating is greater than given rating
        List<String> raitnglist = new ArrayList<>();
        List<Hotel> hotlelist = getHotelDetails();
        hotlelist.forEach(s -> {
            if (s.rating() > rating)
                raitnglist.add(s.name());
        });

        return raitnglist;
    }

    private static List<Hotel> getHotelsByCity(String city) {
        // TODO : Return the list of hotels based on city

        List<Hotel> citylist = new ArrayList<>();
        List<Hotel> hotels = getHotelDetails();
        hotels.forEach(s -> {
            if (s.city().equals(city))
                citylist.add(s);
        });
        return citylist;
        //return Collections.emptyList();
    }

    // City name should be unique
    private static List<String> getCityNames() {
        // TODO : Return the list of city names
        List<String> city = new ArrayList<>();
        List<Hotel> hotels = getHotelDetails();

        hotels.forEach(s -> {
            String name = s.city();
            if (!city.contains(name))
                city.add(name);
        });
        return city;
    }

    private static List<String> getHotelNames(List<Hotel> hotels) {
        // TODO : Return the list of hotel names
        List<String> hotelnames = new ArrayList<>();
        List<Hotel> hotels1 = getHotelDetails();
        hotels1.forEach(s -> {
            hotelnames.add(s.name());
        });
        return hotelnames;
    }

    private static List<Hotel> getHotelDetails() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(ArrayExample.class.getResourceAsStream("/hotel_data.json"), new TypeReference<List<Hotel>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
