package com.meetlovixsx.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.meetlovixsx.app.R;
import com.meetlovixsx.app.databinding.FragmentReg4Binding;
import com.meetlovixsx.app.activity.LineActivity;


public class Reg4Fragment extends Fragment {

    private FragmentReg4Binding binding;
    private static LineActivity activity;

    public static Reg4Fragment newInstance(LineActivity activity) {
        Reg4Fragment.activity = activity;
        return new Reg4Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reg4, container, false);

        binding.btn.setOnClickListener(v -> next());
        return binding.getRoot();
    }

    private void next() {
        if (!binding.radio1.isChecked() && !binding.radio2.isChecked())
            Toast.makeText(activity, getString(R.string.error_radio), Toast.LENGTH_SHORT).show();
        else activity.step5();
    }

}
