package com.that.edcerts.Async;

import android.os.AsyncTask;

import static java.lang.Thread.sleep;

public class AsynStart extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
