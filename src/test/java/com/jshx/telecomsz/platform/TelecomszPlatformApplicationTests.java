package com.jshx.telecomsz.platform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TelecomszPlatformApplicationTests {

    @Test
    public void contextLoads() {

        String kedongsheng = new BCryptPasswordEncoder().encode("kedongsheng");
        System.out.println(kedongsheng);
    }

}
