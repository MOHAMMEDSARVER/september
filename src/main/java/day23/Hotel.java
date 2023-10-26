package day23;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Hotel {
    private String name;
    private HotelType type;
    private double pricePerNight;
    private String city;
    private float rating;

}
