package com.train.aop.code;

import com.train.aop.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AudienceConfig.class})
public class AopCodeTest {

    @Autowired
    private Performance p;

    @Test
    public void objShouldNotBeNull() {
        assertNotNull(p);
    }

    @Test
    public void performanceTest() {
        p.perform();
    }

}