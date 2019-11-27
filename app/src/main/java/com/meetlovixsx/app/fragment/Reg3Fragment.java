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
import com.meetlovixsx.app.databinding.FragmentReg3Binding;
import com.meetlovixsx.app.activity.LineActivity;


public class Reg3Fragment extends Fragment {

    private FragmentReg3Binding binding;
    private static LineActivity activity;

    public static Reg3Fragment newInstance(LineActivity activity) {
        Reg3Fragment.activity = activity;
        return new Reg3Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reg3, container, false);
        binding.city.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) binding.city.clearFocus();
            return false;
        });
        binding.btn.setOnClickListener(v -> next());

        return binding.getRoot();
    }

    private void next() {
        if (binding.city.length()<1)
            Toast.makeText(activity, getString(R.string.error_city), Toast.LENGTH_SHORT).show();
        else activity.step4();
    }

}
