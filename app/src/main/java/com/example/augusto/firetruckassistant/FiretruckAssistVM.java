package com.example.augusto.firetruckassistant;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

import java.util.Objects;
import java.util.Observable;

/**
 * Created by augus on 2018-04-10.
 */

public class FiretruckAssistVM {

    private static FiretruckAssistVM instance = null;

    private Thread SQLthread;
    private FireDB db = new FireDB();

    public ObservableField<String> Name = new ObservableField<>();
    public ObservableField<Integer> ID = new ObservableField<>();
    public ObservableField<Integer> Location = new ObservableField<>();
    public ObservableField<String> Status = new ObservableField<>();
    public ObservableField<Color> StatusColor = new ObservableField<>();
    public ObservableField<String> RouteList = new ObservableField<>();
    public ObservableField<Integer> NumberOfRoutes = new ObservableField<>();

    protected FiretruckAssistVM()
    {
        SQLthread = new Thread(new Runnable() {
            public void run() {
                db.query2();
            }
        });
    }

    public static FiretruckAssistVM GetInstance()
    {
        if (instance == null)
        {
            instance = new FiretruckAssistVM();
        }

        Log.d("TEST", "GetInstance()");

        return instance;
    }

    public void see()
    {
        Log.d("TEST", "see() " + this.Name.get());
    }

    public void connect()
    {
        SQLthread.run();
    }

    public TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }


        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void afterTextChanged(Editable s) {
            Log.d("TEST", "TextChanged() ");
            if (!Objects.equals(Name.get(), s.toString())) {
                Name.set(s.toString());
            }
        }
    };
}
