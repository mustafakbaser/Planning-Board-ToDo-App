package net.mustafabaser.planningboard.data.repo;

import androidx.lifecycle.MutableLiveData;

import net.mustafabaser.planningboard.data.entity.Records;
import net.mustafabaser.planningboard.room.RecordsDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RecordsDaoRepository {
    public MutableLiveData<List<Records>> recordsList = new MutableLiveData<>();
    private RecordsDao recordsDao;
    
    public RecordsDaoRepository(RecordsDao recordsDao){
        this.recordsDao = recordsDao;
    }

    public void create(String record_body){
        Records newRecord = new Records(0, record_body);
        recordsDao.create(newRecord).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onComplete() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }

    public void search(String keyWord){
        recordsDao.search(keyWord).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Records>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onSuccess(List<Records> records) {
                        recordsList.setValue(records);
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void remove(int record_id){
        Records removedRecord = new Records(record_id, "");
        recordsDao.remove(removedRecord).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {
                        loadRecords();
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void loadRecords(){
        recordsDao.loadRecords().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Records>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onSuccess(List<Records> records) {
                        recordsList.setValue(records);
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void update(int record_id, String record_body){
        Records updatedRecord = new Records(record_id, record_body);
        recordsDao.update(updatedRecord).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {}
                    @Override
                    public void onError(Throwable e) {}
                });
    }
}
