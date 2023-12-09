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

        viewModel.errorMessage.observe(getViewLifecycleOwner(), event -> {
            Integer messageId = event.getContentIfNotHandled();
            if (messageId != null) {
                Snackbar.make(binding.getRoot(), messageId, Snackbar.LENGTH_LONG).show();
            }
        });

        binding.fabUpdate.setOnClickListener(v->{
            String record_body = binding.editTextRecordBody.getText().toString();
            if (record_body.trim().isEmpty()) {
                Snackbar.make(v, R.string.empty_task, Snackbar.LENGTH_SHORT).show();
                return;
            }
            viewModel.update(retrievedRecord.getRecord_id(), record_body);
            Navigation.findNavController(v).navigate(R.id.record_detail_back_to_homepage);
        });

        binding.imageViewBackButtonDetail.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.record_detail_back_to_homepage);
        });

        binding.imageViewDeleteButton.setOnClickListener(v->{
            Snackbar.make(v, R.string.delete_task_confirmation, Snackbar.LENGTH_SHORT)
                    .setAction(R.string.confirm, v1->{
                        viewModel.remove(retrievedRecord.getRecord_id());
                        Navigation.findNavController(v).navigate(R.id.record_detail_back_to_homepage);
                        Snackbar.make(v, R.string.task_deleted, Snackbar.LENGTH_SHORT).show();
                    }).show();
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RecordDetailViewModel.class);
    }
}