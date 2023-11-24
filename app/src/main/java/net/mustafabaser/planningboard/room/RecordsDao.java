package net.mustafabaser.planningboard.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import net.mustafabaser.planningboard.data.entity.Records;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface RecordsDao {
    @Query("SELECT * FROM Records")
    Single<List<Records>> loadRecords();

    @Insert
    Completable create(Records record);

    @Update
    Completable update(Records record);

    @Delete
    Completable remove(Records record);

    @Query("SELECT * FROM Records WHERE record_body LIKE '%' || :keyWord || '%'")
    Single<List<Records>> search(String keyWord);
}
