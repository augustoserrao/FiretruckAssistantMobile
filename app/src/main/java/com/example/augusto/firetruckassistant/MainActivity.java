package com.example.augusto.firetruckassistant;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.augusto.firetruckassistant.databinding.ActivityMainBinding;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends Activity{

    FiretruckAssistVM vm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm = FiretruckAssistVM.GetInstance();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVm(vm);
    }

    public void Button_OK_Clicked(View v)
    {
        vm.see();
        Intent intent = new Intent(this ,ActivityFire.class);
        startActivity(intent);
    }
}
