package com.meetlovixsx.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.meetlovixsx.app.R;
import com.meetlovixsx.app.databinding.FragmentReg1Binding;
import com.meetlovixsx.app.activity.LineActivity;


public class Reg1Fragment extends Fragment {

    private FragmentReg1Binding binding;
    private static LineActivity activity;

    public static Reg1Fragment newInstance(LineActivity activity) {
        Reg1Fragment.activity = activity;
        return new Reg1Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reg1, container, false);
        binding.email.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) binding.email.clearFocus();
            return false;
        });
        binding.btn.setOnClickListener(v -> next());
        return binding.getRoot();
    }

    private void next() {
        if (binding.email.length()<1)
            Toast.makeText(activity, getString(R.string.error_email), Toast.LENGTH_SHORT).show();
        else activity.step2();
    }

}
