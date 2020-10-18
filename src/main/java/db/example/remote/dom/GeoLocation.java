package db.example.remote.dom;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoLocation {

    private final double latitude;
    private final double longitude;

}
