package net.mustafabaser.planningboard.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import net.mustafabaser.planningboard.data.entity.Records;
import net.mustafabaser.planningboard.databinding.RecordCardDesignBinding;
import net.mustafabaser.planningboard.ui.fragment.HomePageFragmentDirections;
import net.mustafabaser.planningboard.ui.viewmodel.HomePageViewModel;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordCardDesignHolder> {
    private List<Records> recordsList;
    private Context mContext;
    private HomePageViewModel viewModel;

    public RecordAdapter(List<Records> recordsList, Context mContext, HomePageViewModel viewModel) {
        this.recordsList = recordsList;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    public class RecordCardDesignHolder extends RecyclerView.ViewHolder{
        private RecordCardDesignBinding cardDesignBinding;

        public RecordCardDesignHolder(RecordCardDesignBinding cardDesignBinding){
            super(cardDesignBinding.getRoot());
            this.cardDesignBinding = cardDesignBinding;
        }
    }

    @NonNull
    @Override
    public RecordCardDesignHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecordCardDesignBinding binding = RecordCardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new RecordCardDesignHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordAdapter.RecordCardDesignHolder holder, int position) {
        Records record = recordsList.get(position);
        RecordCardDesignBinding cardBinding = holder.cardDesignBinding;
        cardBinding.textViewRecordBody.setText(record.getRecord_body());

        cardBinding.imageViewDelete.setOnClickListener(v->{
                Snackbar.make(v, "This task will be deleted, are you sure?", Snackbar.LENGTH_SHORT)
                        .setAction("CONFIRM", v1->{
                            viewModel.remove(record.getRecord_id());
                        }).show();
        });

        cardBinding.cardViewLine.setOnClickListener(v -> {
            HomePageFragmentDirections.HomepageToRecordDetail toRecordDetail = HomePageFragmentDirections.homepageToRecordDetail(record);
            Navigation.findNavController(v).navigate(toRecordDetail);
        });
    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }
}
