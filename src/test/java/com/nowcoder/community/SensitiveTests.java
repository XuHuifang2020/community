package com.nowcoder.community;

import com.nowcoder.community.util.SensitiveFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTests {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void textSensitiveFilter() {
        String text = "这里不可以赌博，不可以嫖娼，不可以吸毒，不可以开票，对对对!";
        text = sensitiveFilter.filter(text);
        System.out.println(text);

        text = "这里不可以#赌$博#，不可以嫖$娼，不可以吸&毒，不可以开&票，对对对!";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }

}
