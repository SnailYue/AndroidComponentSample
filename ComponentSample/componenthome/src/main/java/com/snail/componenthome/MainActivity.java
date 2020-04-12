package com.snail.componenthome;

import android.os.Bundle;
import android.view.MotionEvent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.snail.componentbasic.BaseActivity;
import com.snail.componentbasic.Constance;

@Route(path = Constance.HomeMainActivity)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ARouter.getInstance().build(Constance.ContactsMainActivity).navigation();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
