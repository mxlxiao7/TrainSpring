package com.train.bean.config.mix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MixConfig.class})
public class MixConfigTest {

    @Autowired
    private A a;
    @Autowired
    private B b;
    @Autowired
    private C c;
    @Autowired
    private D d;

    @Test
    public void objShouldNotBeNull() {
        assertNotNull(a);
        assertNotNull(b);
        assertNotNull(c);
        assertNotNull(d);
    }

}