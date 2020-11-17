package com.example.todolist.screens.main;

import com.example.todolist.App;
import com.example.todolist.model.Note;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private LiveData<List<Note>> noteLiveDate = App.getInstance().getNoteDao().getAllLiveData();

    public LiveData<List<Note>> getNoteLiveDate() {
        return noteLiveDate;
    }
}
