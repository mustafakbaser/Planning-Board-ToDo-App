package net.mustafabaser.planningboard.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Records")
public class Records  implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "record_id")
    @NonNull
    private int record_id;

    @ColumnInfo(name = "record_body")
    @NonNull
    private String record_body;

    public Records(){
    }
    public Records(int record_id, @NonNull String record_body) {
        this.record_id = record_id;
        this.record_body = record_body;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    @NonNull
    public String getRecord_body() {
        return record_body;
    }

    public void setRecord_body(@NonNull String record_body) {
        this.record_body = record_body;
    }
}
