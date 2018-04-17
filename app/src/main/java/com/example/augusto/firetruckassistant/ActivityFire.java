package com.example.augusto.firetruckassistant;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.augusto.firetruckassistant.databinding.ActivityFireBinding;

public class ActivityFire extends Activity {

    FiretruckAssistVM vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        vm = FiretruckAssistVM.GetInstance();
        ActivityFireBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_fire);
        binding.setVm(vm);
    }

    public void Button_Start_Clicked(View v)
    {
        vm.see();
        vm.connect();
    }
}
