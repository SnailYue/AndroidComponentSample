package com.snail.componentbasic.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {
    private List<BaseFragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
    }

    public void addFragment(BaseFragment fragment, int id) {
        if (!fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(id, fragment).commit();
            fragments.add(fragment);
        }
    }

    public void showFragment(int tag) {
        switch (tag) {
            case 0:
                showFragment(fragments.get(0));
                break;
            case 1:
                showFragment(fragments.get(1));
                break;
            case 2:
                showFragment(fragments.get(2));
                break;
        }
    }

    public void showFragment(BaseFragment frag) {
        for (BaseFragment fragment : fragments) {
            if (frag != fragment) {
                getSupportFragmentManager().beginTransaction().hide(fragment).commit();
            }
        }
        getSupportFragmentManager().beginTransaction().show(frag).commit();
    }
}
