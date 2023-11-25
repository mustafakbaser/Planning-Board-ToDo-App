package net.mustafabaser.planningboard.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import net.mustafabaser.planningboard.data.entity.Records;

@Database(entities = {Records.class}, version = 1)
public abstract class DatabaseRecords extends RoomDatabase {
    public abstract RecordsDao getRecordsDao();
}
