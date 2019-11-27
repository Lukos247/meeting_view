package com.meetlovixsx.app.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.meetlovixsx.app.R;
import com.meetlovixsx.app.fragment.Reg1Fragment;
import com.meetlovixsx.app.fragment.Reg2Fragment;
import com.meetlovixsx.app.fragment.Reg3Fragment;
import com.meetlovixsx.app.fragment.Reg4Fragment;
import com.meetlovixsx.app.fragment.Reg5Fragment;

public class LineActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        step1();
    }

    public void step1() {

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left)
                .replace(R.id.container, Reg1Fragment.newInstance(this))
                .commit();
    }

    public void step2() {

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left)
                .replace(R.id.container, Reg2Fragment.newInstance(this))
                .commit();
    }

    public void step3() {

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left)
                .replace(R.id.container, Reg3Fragment.newInstance(this))
                .commit();
    }

    public void step4() {

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left)
                .replace(R.id.container, Reg4Fragment.newInstance(this))
                .commit();
    }

    public void step5() {

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left)
                .replace(R.id.container, Reg5Fragment.newInstance(this))
                .commit();
    }
}
