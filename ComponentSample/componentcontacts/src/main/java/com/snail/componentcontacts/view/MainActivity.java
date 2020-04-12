package com.snail.componentcontacts.view;

import android.os.Bundle;
import android.view.MotionEvent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.snail.componentbasic.base.BaseActivity;
import com.snail.componentbasic.util.Constance;
import com.snail.componentcontacts.R;

@Route(path = Constance.ContactsMainActivity)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ARouter.getInstance().build(Constance.SettingMainActivity).navigation();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
