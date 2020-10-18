package db.example.service;

import db.example.dom.DummyData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface DummyService {

    DummyData getDummy(UUID id);

    List<DummyData> getAllDummies();
}
