package com.meetlovixsx.app.model;

import com.meetlovixsx.app.R;

import java.util.ArrayList;
import java.util.Collections;

public class Data {
    public static ArrayList<GirlOb> getData(){
        ArrayList<GirlOb> items = new ArrayList<>();
        items.add(new GirlOb("Kira, 20","Moscow, Russia", R.drawable._pik1));
        items.add(new GirlOb("Selene, 21","Moscow, Russia",R.drawable._pik2));
        items.add(new GirlOb("Margarita, 22","Moscow, Russia",R.drawable._pik3));
        items.add(new GirlOb("Nina, 24","Moscow, Russia",R.drawable._pik4));
        items.add(new GirlOb("Anastasia, 25","Moscow, Russia",R.drawable._pik5));
        items.add(new GirlOb("Jessie, 27","Moscow, Russia",R.drawable._pik6));
        items.add(new GirlOb("Joanna, 23","Moscow, Russia",R.drawable._pik7));
        items.add(new GirlOb("Lori, 22","Moscow, Russia",R.drawable._pik8));
        items.add(new GirlOb("Joan, 19","Moscow, Russia",R.drawable._pik9));
        items.add(new GirlOb("Julia, 18","Moscow, Russia",R.drawable._pik10));
        items.add(new GirlOb("Alexa, 21","Moscow, Russia",R.drawable.girl2));
        items.add(new GirlOb("Alanna, 20","Moscow, Russia",R.drawable.girl3));

        Collections.shuffle(items);
        return items;
    }
}
