package com.example.basic1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
public class MainServiceTest {
    @TestConfiguration
    static class MainServiceTestContextConfiguration {

        @Bean
        public MainService mainService() {
            return new MainServiceImpl();
        }
        @Bean
        public TableHelper tableHelper(){
            return new TableHelper();
        }
    }

    @Autowired
    private MainService mainService;

    @MockBean
    private MainTableRepository mainTableRepository;

    @Before
    public void setUp() {
        MainTable mainTable = new MainTable();
        mainTable.setPhoneNumber(10101);
        mainTable.setHashNumber("ddd");

        Mockito.when(mainTableRepository.findByPhoneNumber(mainTable.getPhoneNumber()))
                .thenReturn(mainTable);

    }

    @Test
    public void whenValidNumber_thenMainTableHashByPhoneNumberShouldBeFound() {
        int number = 10101;
        String hash = "ddd";
        String found = mainService.getHashByNumber(number);

        assertThat(found)
                .isEqualTo(hash);
    }
}
