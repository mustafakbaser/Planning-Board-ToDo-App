package net.mustafabaser.planningboard.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import net.mustafabaser.planningboard.data.repo.RecordsDaoRepository;
import net.mustafabaser.planningboard.util.Event;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class RecordCreateViewModel extends ViewModel {

    public RecordsDaoRepository recordsDaoRepository;
    public LiveData<Event<Integer>> errorMessage;

    @Inject
    public RecordCreateViewModel(RecordsDaoRepository recordsDaoRepository){
        this.recordsDaoRepository = recordsDaoRepository;
        errorMessage = recordsDaoRepository.errorMessage;
    }

    public void create(String record_body){
        recordsDaoRepository.create(record_body);
    }
}
