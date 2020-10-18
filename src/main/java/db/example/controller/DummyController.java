package db.example.controller;

import db.example.dom.DummyData;
import db.example.service.DummyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/dummies")
public class DummyController {

    private final DummyService dummyService;

    @GetMapping
    public List<DummyData> getDummies() {
        return dummyService.getAllDummies();
    }

    @GetMapping(value = "/{id}")
    public DummyData getDummyById(@PathVariable("id") final UUID id) {
        return dummyService.getDummy(id);
    }
}
