package net.mustafabaser.planningboard.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.mustafabaser.planningboard.R;
import net.mustafabaser.planningboard.databinding.FragmentCreateRecordBinding;
import net.mustafabaser.planningboard.ui.viewmodel.RecordCreateViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RecordCreateFragment extends Fragment {
    private FragmentCreateRecordBinding binding;
    private RecordCreateViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateRecordBinding.inflate(inflater, container, false);

        binding.fabCreate.setOnClickListener(v->{
            String record_body = binding.editTextRecordBody.getText().toString();
            viewModel.create(record_body);
            Navigation.findNavController(v).navigate(R.id.record_create_back_to_homepage);
        });

        binding.editTextRecordBody.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(view.hasFocus()){
                    binding.editTextRecordBody.setText("");
                }
            }
        });

        binding.imageViewBackButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.record_create_back_to_homepage);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RecordCreateViewModel.class);
    }
}