package net.mustafabaser.planningboard.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import net.mustafabaser.planningboard.data.repo.RecordsDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class RecordCreateViewModel extends ViewModel {

    public RecordsDaoRepository recordsDaoRepository;

    @Inject
    public RecordCreateViewModel(RecordsDaoRepository recordsDaoRepository){
        this.recordsDaoRepository = recordsDaoRepository;
    }

    public void create(String record_body){
        recordsDaoRepository.create(record_body);
    }
}
