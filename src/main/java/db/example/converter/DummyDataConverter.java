package db.example.converter;

import db.example.dom.DummyData;
import db.example.model.DummyEntity;

public class DummyDataConverter {

    private DummyDataConverter() {
    }

    public static DummyData toDummyData(final DummyEntity source) {
        return DummyData.builder().id(source.getId()).name(source.getName()).build();
    }
}
