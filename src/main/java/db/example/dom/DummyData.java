package db.example.dom;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class DummyData implements Serializable {

    private UUID id;
    private String name;
}
