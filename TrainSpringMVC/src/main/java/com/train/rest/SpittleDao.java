package com.train.rest;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("spittleDao")
public class SpittleDao {
    public List<Spittle> findSpittles(long max, int count) {
        return getAllSpittles();
    }

    public List<Spittle> getAllSpittles() {
        List<Spittle> list = new ArrayList<Spittle>();
        for (int i = 0; i < 15; i++) {
            list.add(new Spittle(i + 0L, "leon " + i, 20 + i, "message " + i, ""));
        }
        return list;
    }
}
