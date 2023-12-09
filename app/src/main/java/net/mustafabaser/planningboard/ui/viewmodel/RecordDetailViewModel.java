package net.mustafabaser.planningboard.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import net.mustafabaser.planningboard.data.repo.RecordsDaoRepository;
import net.mustafabaser.planningboard.util.Event;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class RecordDetailViewModel extends ViewModel {
    public RecordsDaoRepository recordsDaoRepository;
    public LiveData<Event<Integer>> errorMessage;

    @Inject
    public RecordDetailViewModel(RecordsDaoRepository recordsDaoRepository){
        this.recordsDaoRepository = recordsDaoRepository;
        errorMessage = recordsDaoRepository.errorMessage;
    }

    public void update(int record_id, String record_body){
        recordsDaoRepository.update(record_id, record_body);
    }

    public void remove(int record_id){
        recordsDaoRepository.remove(record_id);
    }
}
