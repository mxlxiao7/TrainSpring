package com.train.bean.config.auto;


import com.train.bean.config.code.Car;
import com.train.bean.config.code.CodeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CodeConfig.class})
public class CodeConfigTest {

    @Autowired
    private Car car;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(car);
    }

    @Test
    public void moveTest() {
        car.move();
    }

}