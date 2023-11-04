package com.samsclub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@DataJpaTest
@Transactional
@SpringBootTest
class SamsClubProjectApplicationTests {

    @Test
    void contextLoads() {
    }

}
