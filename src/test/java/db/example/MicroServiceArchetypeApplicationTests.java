package db.example;

import db.example.respository.DummyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MicroServiceArchetypeApplicationTests {

	@Autowired
	private DummyRepository dummyRepository;

	@Test
	void contextLoads() {
		var dummies = dummyRepository.findAll();
		assertNotNull(dummies);
		assertEquals(9, dummies.size());
	}

}
