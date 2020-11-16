package com.example.todolist.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity ntity
public class Note implements Parcelable {
    public int uid;
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "text")
    public String text;

    @ColumnInfo(name = "timestamp")
    public long timestamp;


    @ColumnInfo(name = "done")
    public boolean done;

    protected Note(Parcel in) {
        uid = in.readInt();
        text = in.readString();
        timestamp = in.readLong();
        done = in.readByte() != 0;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return uid == note.uid &&
                timestamp == note.timestamp &&
                done == note.done &&
                Objects.equals(text, note.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, text, timestamp, done);
    }

    public Note()
    {
        @Override
        public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uid);
        dest.writeString(text);
        dest.writeLong(timestamp);
        dest.writeByte((byte) (done ? 1 : 0));
    }

        @Override
        public int describeContents() {
        return 0;
    }

        public static final Creator<Note> CREATOR = new Creator<Note>() {
            @Override
            public Note createFromParcel(Parcel in) {
                return new Note(in);
            }

            @Override
            public Note[] newArray(int size) {
                return new Note[size];
            }
        };
    }
}
