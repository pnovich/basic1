package com.example.basic1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

//import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase
public class MainTableRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private MainTableRepository mainTableRepository;
    @Test
    public void whenFindByPhoneNumber_thenReturnMainTable() {
        // given
        MainTable mainTable = new MainTable();
        mainTable.setPhoneNumber(10101);
        mainTable.setHashNumber("fgfgfgg");
        entityManager.persist(mainTable);
        entityManager.flush();
//        mainTableRepository.save(mainTable);

        // when
        MainTable found = mainTableRepository.findByPhoneNumber(mainTable.getPhoneNumber());

        // then
        assertThat(found.getPhoneNumber())
                .isEqualTo(mainTable.getPhoneNumber());
    }
}
