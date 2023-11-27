package net.mustafabaser.planningboard.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import net.mustafabaser.planningboard.R;
import net.mustafabaser.planningboard.data.entity.Records;
import net.mustafabaser.planningboard.databinding.FragmentRecordDetailBinding;
import net.mustafabaser.planningboard.ui.viewmodel.RecordDetailViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RecordDetailFragment extends Fragment {
    private FragmentRecordDetailBinding binding;
    private RecordDetailViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecordDetailBinding.inflate(inflater, container, false);

        RecordDetailFragmentArgs bundle = RecordDetailFragmentArgs.fromBundle(getArguments());
        Records retrievedRecord = bundle.getRecord();

        binding.editTextRecordBody.setText(retrievedRecord.getRecord_body().toString());

        binding.buttonUpdate.setOnClickListener(v->{
            String record_body = binding.editTextRecordBody.getText().toString();
            viewModel.update(retrievedRecord.getRecord_id(), record_body);
            Navigation.findNavController(v).navigate(R.id.record_detail_back_to_homepage);
        });

        binding.imageViewBackButtonDetail.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.record_detail_back_to_homepage);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RecordDetailViewModel.class);
    }
}