package com.meetlovixsx.app.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.meetlovixsx.app.R;
import com.meetlovixsx.app.databinding.ActivityFinalBinding;
import com.meetlovixsx.app.model.Data;
import com.meetlovixsx.app.model.GirlOb;
import com.meetlovixsx.app.model.GirldObAdapter;

public class FinalActivity extends AppCompatActivity implements GirldObAdapter.listener {

    ActivityFinalBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_final);
        GirldObAdapter adapter = new GirldObAdapter(this, Data.getData());
        binding.recycler.setAdapter(adapter);
    }

    @Override
    public void onClick(GirlOb woman) {
        Toast.makeText(this, "Ошибка! Попробуйте позднее..", Toast.LENGTH_SHORT).show();
    }
}
