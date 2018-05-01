package com.train.rest;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("spittleDao")
public class SpittleDao {
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> list = new ArrayList<Spittle>();
        for (int i = 0; i < 5; i++) {
            list.add(new Spittle("name:" + i, i + ""));

        }
        return list;
    }
}
