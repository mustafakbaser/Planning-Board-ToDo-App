package net.mustafabaser.planningboard.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import net.mustafabaser.planningboard.R;
import net.mustafabaser.planningboard.databinding.FragmentHomePageBinding;
import net.mustafabaser.planningboard.ui.adapter.RecordAdapter;
import net.mustafabaser.planningboard.ui.viewmodel.HomePageViewModel;

public class HomePageFragment extends Fragment {
    private FragmentHomePageBinding binding;
    private HomePageViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomePageBinding.inflate(inflater, container, false);

        binding.recordsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.recordsList.observe(getViewLifecycleOwner(), recordsList -> {
            RecordAdapter adapter = new RecordAdapter(recordsList, requireContext(), viewModel);
            binding.recordsRecyclerView.setAdapter(adapter);
        });

        binding.floatingActionButton.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.homepage_to_create_record);
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String queryString) {
                viewModel.search(queryString);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newString) {
                viewModel.search(newString);
                return true;
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomePageViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.loadRecords();
    }
}