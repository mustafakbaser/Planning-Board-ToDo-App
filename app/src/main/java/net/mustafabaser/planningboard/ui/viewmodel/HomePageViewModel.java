package net.mustafabaser.planningboard.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import net.mustafabaser.planningboard.data.entity.Records;
import net.mustafabaser.planningboard.data.repo.RecordsDaoRepository;

import java.util.List;

public class HomePageViewModel extends ViewModel {
    public RecordsDaoRepository recordsDaoRepository;
    public MutableLiveData<List<Records>> recordsList;

    public HomePageViewModel(RecordsDaoRepository recordsDaoRepository){
        this.recordsDaoRepository = recordsDaoRepository;
        loadRecords();
        recordsList = recordsDaoRepository.recordsList;
    }

    public void search(String keyWord){
        recordsDaoRepository.search(keyWord);
    }

    public void remove(int record_id){
        recordsDaoRepository.remove(record_id);
    }

    public void loadRecords(){
        recordsDaoRepository.loadRecords();
    }

}
