package net.mustafabaser.planningboard.di;

import android.content.Context;

import androidx.room.Room;

import net.mustafabaser.planningboard.data.repo.RecordsDaoRepository;
import net.mustafabaser.planningboard.room.DatabaseRecords;
import net.mustafabaser.planningboard.room.RecordsDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public RecordsDaoRepository provideRecordsDaoRepository(RecordsDao recordsDao){
        return new RecordsDaoRepository(recordsDao);
    }

    @Provides
    @Singleton
    public RecordsDao provideRecordsDao(@ApplicationContext Context context){
        DatabaseRecords db = Room.databaseBuilder(context, DatabaseRecords.class, "records.sqlite")
                .createFromAsset("records.sqlite").build();
        return db.getRecordsDao();
    }
}
