package net.mustafabaser.planningboard.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import net.mustafabaser.planningboard.data.entity.Records;
import net.mustafabaser.planningboard.data.repo.RecordsDaoRepository;
import net.mustafabaser.planningboard.util.Event;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomePageViewModel extends ViewModel {
    public RecordsDaoRepository recordsDaoRepository;
    public MutableLiveData<List<Records>> recordsList;
    public LiveData<Event<Integer>> errorMessage;

    @Inject
    public HomePageViewModel(RecordsDaoRepository recordsDaoRepository){
        this.recordsDaoRepository = recordsDaoRepository;
        loadRecords();
        recordsList = recordsDaoRepository.recordsList;
        errorMessage = recordsDaoRepository.errorMessage;
    }

    public void loadRecords(){
        recordsDaoRepository.loadRecords();
    }

    public void search(String keyWord){
        recordsDaoRepository.search(keyWord);
    }

    public void remove(int record_id){
        recordsDaoRepository.remove(record_id);
    }
}
