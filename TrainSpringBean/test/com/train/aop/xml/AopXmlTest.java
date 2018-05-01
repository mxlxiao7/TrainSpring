package com.train.aop.xml;


import com.train.aop.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:com/train/aop/xml/aop-config.xml"})
public class AopXmlTest {

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