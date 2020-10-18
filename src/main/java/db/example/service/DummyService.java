package db.example.service;

import db.example.dom.DummyData;

import java.util.List;
import java.util.UUID;

public interface DummyService {

    DummyData getDummy(UUID id);

    List<DummyData> getAllDummies();
}
