package com.meetlovixsx.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.meetlovixsx.app.R;
import com.meetlovixsx.app.databinding.FragmentReg5Binding;
import com.meetlovixsx.app.activity.FinalActivity;
import com.meetlovixsx.app.activity.LineActivity;


public class Reg5Fragment extends Fragment {

    private FragmentReg5Binding binding;
    private static LineActivity activity;

    public static Reg5Fragment newInstance(LineActivity activity) {
        Reg5Fragment.activity = activity;
        return new Reg5Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reg5, container, false);

        binding.btn.setOnClickListener(v -> startActivity(new Intent(activity, FinalActivity.class)));
        return binding.getRoot();
    }

}
