package db.example.remote.dom;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {

    private final String name;
    private final String catchPhrase;
    private final String bs;
}
