package db.example.service.impl;

import db.example.converter.DummyDataConverter;
import db.example.dom.DummyData;
import db.example.model.DummyEntity;
import db.example.respository.DummyRepository;
import db.example.service.DummyService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DummyServiceImpl implements DummyService {

    private final DummyRepository dummyRepository;

    @Override
    public DummyData getDummy(UUID id) {
        final Optional<DummyEntity> dummyEntity = dummyRepository.findById(id);
        return dummyEntity.map(DummyDataConverter::toDummyData).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<DummyData> getAllDummies() {
        return dummyRepository.findAll().stream().map(DummyDataConverter::toDummyData).collect(Collectors.toList());
    }
}
