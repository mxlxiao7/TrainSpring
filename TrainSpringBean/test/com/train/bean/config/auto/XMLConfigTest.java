package com.train.bean.config.auto;


import com.train.bean.config.xml.Gun;
import com.train.bean.config.xml.Weapon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:com/train/bean/config/xml/code-config.xml"})
public class XMLConfigTest {


    @Autowired
    private Weapon weapon;

    @Autowired
    private Weapon weapon2;

    @Autowired
    private Gun gun;


    @Test
    public void gunShouldNotBeNull() {
        assertNotNull(gun);
    }

    @Test
    public void weaponShouldNotBeNull() {
        assertNotNull(weapon);
    }

    @Test
    public void shootTest(){
        weapon.shoot();
        weapon2.shoot();
    }


}