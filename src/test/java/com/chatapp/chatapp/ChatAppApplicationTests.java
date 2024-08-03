package com.chatapp.chatapp;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@Ignore
class ChatAppApplicationTests {

    @Test
    void contextLoads() {
    }

}
