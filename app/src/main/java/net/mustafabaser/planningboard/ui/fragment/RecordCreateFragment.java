package net.mustafabaser.planningboard.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.mustafabaser.planningboard.R;
import net.mustafabaser.planningboard.databinding.FragmentCreateRecordBinding;
import net.mustafabaser.planningboard.ui.viewmodel.RecordCreateViewModel;

public class RecordCreateFragment extends Fragment {
    private FragmentCreateRecordBinding binding;
    private RecordCreateViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateRecordBinding.inflate(inflater, container, false);

        /* To-Do

        Button features will be added.
        */


        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RecordCreateViewModel.class);
    }
}