package net.mustafabaser.planningboard.data.repo;

import android.util.Log;

import androidx.annotation.StringRes;
import androidx.lifecycle.MutableLiveData;

import net.mustafabaser.planningboard.R;
import net.mustafabaser.planningboard.data.entity.Records;
import net.mustafabaser.planningboard.room.RecordsDao;
import net.mustafabaser.planningboard.util.Event;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RecordsDaoRepository {
    private static final String TAG = "RecordsDaoRepository";

    public MutableLiveData<List<Records>> recordsList = new MutableLiveData<>();
    public MutableLiveData<Event<Integer>> errorMessage = new MutableLiveData<>();
    private RecordsDao recordsDao;
    
    public RecordsDaoRepository(RecordsDao recordsDao){
        this.recordsDao = recordsDao;
    }

    private void reportError(String logMessage, @StringRes int messageId, Throwable e){
        Log.e(TAG, logMessage, e);
        errorMessage.setValue(new Event<>(messageId));
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
                        loadRecords();
                    }
                    @Override
                    public void onError(Throwable e) {
                        reportError("Could not create record", R.string.error_create_task, e);
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
                    public void onError(Throwable e) {
                        reportError("Could not search records", R.string.error_search_tasks, e);
                    }
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
                    public void onError(Throwable e) {
                        reportError("Could not remove record " + record_id, R.string.error_delete_task, e);
                    }
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
                    public void onError(Throwable e) {
                        reportError("Could not load records", R.string.error_load_tasks, e);
                    }
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
                    public void onComplete() {
                        loadRecords();
                    }
                    @Override
                    public void onError(Throwable e) {
                        reportError("Could not update record " + record_id, R.string.error_update_task, e);
                    }
                });
    }
}
