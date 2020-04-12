package com.snail.componentsetting;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.snail.componentbasic.base.BaseActivity;
import com.snail.componentbasic.util.Constance;

@Route(path = Constance.SettingMainActivity)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity_main);
    }
}
