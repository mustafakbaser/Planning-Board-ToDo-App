package net.mustafabaser.planningboard.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.mustafabaser.planningboard.R;
import net.mustafabaser.planningboard.databinding.FragmentCreateRecordBinding;

public class RecordCreateFragment extends Fragment {
    private FragmentCreateRecordBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateRecordBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}