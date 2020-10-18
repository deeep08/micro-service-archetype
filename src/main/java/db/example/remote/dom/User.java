package db.example.remote.dom;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private final long id;
    private final String name;
    private final String username;
    private final String email;
    private final Address address;
    private final String phone;
    private final String website;
    private final Company company;

}
