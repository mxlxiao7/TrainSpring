package com.train.bean.config.auto;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AutoConfig.class})
public class AutoConfigTest {


    @Autowired
    private Plane plane;

    @Test
    public void objShouldNotBeNull() {
        assertNotNull(plane);
    }

    @Test
    public void flyTest() {
        plane.fly();
    }

    @Test
    public void useTest() {
        plane.use();
    }
}