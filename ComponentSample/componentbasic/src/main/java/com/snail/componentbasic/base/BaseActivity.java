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

    /**
     * 添加fragment
     *
     * @param fragment
     * @param id
     */
    public void addFragment(BaseFragment fragment, int id) {
        if (!fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(id, fragment).commit();
            fragments.add(fragment);
        }
    }

    /**
     * 根据tag切换fragment
     *
     * @param tag
     */
    public void showFragment(int tag) {
        showFragment(fragments.get(tag));
    }

    /**
     * 显示fragment
     *
     * @param frag
     */
    public void showFragment(BaseFragment frag) {
        for (BaseFragment fragment : fragments) {
            if (frag != fragment) {
                getSupportFragmentManager().beginTransaction().hide(fragment).commit();
            }
        }
        getSupportFragmentManager().beginTransaction().show(frag).commit();
    }
}
