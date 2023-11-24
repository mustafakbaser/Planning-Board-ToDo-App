package net.mustafabaser.planningboard.room;

import androidx.room.RoomDatabase;

import net.mustafabaser.planningboard.data.entity.Records;

@androidx.room.Database(entities = {Records.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract RecordsDao getRecordsDao();
}
