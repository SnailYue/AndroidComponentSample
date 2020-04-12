package com.snail.componentsample;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.snail.componentbasic.base.BaseActivity;
import com.snail.componentbasic.util.Constance;
import com.snail.componentcontacts.view.fragment.ContactsFragment;
import com.snail.componenthome.view.fragment.HomeFragment;
import com.snail.componentsample.R;
import com.snail.componentsetting.view.fragment.SettingFragment;


@Route(path = Constance.AppMainActivity)
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getName();
    private static final String HOME_FRAGMENT_KEY = "HomeFragment";
    private static final String CONTACTS_FRAGMENT_KEY = "ContactsFragment";
    private static final String SETTING_FRAGMENT_KEY = "SettingFragment";

    private HomeFragment homeFragment;
    private ContactsFragment contactsFragment;
    private SettingFragment settingFragment;

    private TextView homeButton;
    private TextView contactsButton;
    private TextView settingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment(savedInstanceState);
    }

    public void initView() {
        homeButton = findViewById(R.id.tv_home);
        homeButton.setOnClickListener(this);
        contactsButton = findViewById(R.id.tv_contacts);
        contactsButton.setOnClickListener(this);
        settingButton = findViewById(R.id.tv_setting);
        settingButton.setOnClickListener(this);
    }

    public void initFragment(Bundle savedInstanceState) {
        clearFragmentList();
        if (null != savedInstanceState) {
            homeFragment = (HomeFragment) getSupportFragmentManager().getFragment(savedInstanceState, HOME_FRAGMENT_KEY);
            contactsFragment = (ContactsFragment) getSupportFragmentManager().getFragment(savedInstanceState, CONTACTS_FRAGMENT_KEY);
            settingFragment = (SettingFragment) getSupportFragmentManager().getFragment(savedInstanceState, SETTING_FRAGMENT_KEY);
        } else {
            homeFragment = new HomeFragment();
            contactsFragment = new ContactsFragment();
            settingFragment = new SettingFragment();
        }
        addFragment(homeFragment, R.id.fl_container);
        addFragment(contactsFragment, R.id.fl_container);
        addFragment(settingFragment, R.id.fl_container);
        showFragment(homeFragment);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (null != homeFragment) {
            getSupportFragmentManager().putFragment(outState, HOME_FRAGMENT_KEY, homeFragment);
        }
        if (null != contactsFragment) {
            getSupportFragmentManager().putFragment(outState, CONTACTS_FRAGMENT_KEY, contactsFragment);
        }
        if (null != settingFragment) {
            getSupportFragmentManager().putFragment(outState, SETTING_FRAGMENT_KEY, settingFragment);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_home:
                showFragment(homeFragment);
                break;
            case R.id.tv_contacts:
                showFragment(contactsFragment);
                break;
            case R.id.tv_setting:
                showFragment(settingFragment);
                break;

        }
    }
}
