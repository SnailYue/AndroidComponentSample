package com.snail.componentsample;


import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.snail.componentbasic.BaseActivity;
import com.snail.componentbasic.Constance;


@Route(path = Constance.AppMainActivity)
public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onTouchEvent: down");
                ARouter.getInstance().build(Constance.HomeMainActivity).navigation();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
