package net.mustafabaser.planningboard.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.mustafabaser.planningboard.R;
import net.mustafabaser.planningboard.data.entity.Records;
import net.mustafabaser.planningboard.databinding.FragmentRecordDetailBinding;
import net.mustafabaser.planningboard.ui.viewmodel.RecordDetailViewModel;

public class RecordDetailFragment extends Fragment {
    private FragmentRecordDetailBinding binding;
    private RecordDetailViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecordDetailBinding.inflate(inflater, container, false);

        RecordDetailFragmentArgs bundle = RecordDetailFragmentArgs.fromBundle(getArguments());
        Records retrievedRecord = bundle.getRecord();

        /* To-Do

        Edittext and Button features will be added.
        */

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RecordDetailViewModel.class);
    }
}