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
import com.meetlovixsx.app.databinding.FragmentReg2Binding;
import com.meetlovixsx.app.activity.LineActivity;


public class Reg2Fragment extends Fragment {

    private FragmentReg2Binding binding;
    private static LineActivity activity;

    public static Reg2Fragment newInstance(LineActivity activity) {
        Reg2Fragment.activity = activity;
        return new Reg2Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reg2, container, false);
        binding.name.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) binding.name.clearFocus();
            return false;
        });
        binding.btn.setOnClickListener(v -> next());

        return binding.getRoot();
    }

    private void next() {
        if (binding.name.length()<1)
            Toast.makeText(activity, getString(R.string.error_name), Toast.LENGTH_SHORT).show();
        else activity.step3();
    }

}
