package com.snail.componenthome.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.snail.componentbasic.base.BaseActivity;
import com.snail.componentbasic.base.BaseFragment;
import com.snail.componentbasic.util.Constance;
import com.snail.componenthome.R;
import com.snail.componenthome.presenter.HomePresenter;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;

@Route(path = Constance.HomeFragment)
public class HomeFragment extends BaseFragment implements IView {
    private static final String TAG = HomeFragment.class.getName();
    private FrameLayout layout;
    private View view;
    public HomePresenter homePresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        layout = view.findViewById(R.id.fl_view);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: click");
                ((BaseActivity) getActivity()).showFragment(Constance.ContactsFragmentTag);
            }
        });
        return view;
    }

    public void initData() {
        homePresenter = new HomePresenter(this);
        /**
         * 发起获取用户信息的请求
         */
        homePresenter.loadUserInfo();
    }

    @Override
    public void initView() {

    }

    @Override
    public void showProgress() {
        Log.d(TAG, "showProgress: showProgress");
    }

    @Override
    public void hideProgress() {
        Log.d(TAG, "hideProgress: hideProgress");
    }

    @Override
    public void showMessage() {

    }
}
