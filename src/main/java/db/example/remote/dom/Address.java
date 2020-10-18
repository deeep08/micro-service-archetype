package db.example.remote.dom;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private final String street;
    private final String suite;
    private final String city;
    private final String zipcode;
    private final GeoLocation geoLocation;
}
