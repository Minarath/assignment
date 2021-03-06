package com.example.assignment.di.base.viewmodel;

import androidx.annotation.MainThread;

public class SingleActionEvent<T> extends SingleLiveEvent<T> {
    /**
     * Used for cases where T is Void, to make calls cleaner.
     */
    @MainThread
    public void call() {
        setValue(null);
    }


    @MainThread
    public void call(T v) {
        setValue(v);
    }


}
