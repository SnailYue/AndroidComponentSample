package com.snail.componenthome.presenter;

import android.util.Log;

import com.snail.componenthome.bean.User;
import com.snail.componenthome.model.FindInformation;
import com.snail.componenthome.view.fragment.IView;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;

public class HomePresenter {
    private static final String TAG = HomePresenter.class.getName();
    private IView view;
    private User userInfo;

    public HomePresenter(IView view) {
        this.view = view;
    }

    /**
     * 加载用户信息
     */
    public void loadUserInfo() {
        /**
         * 使用rxjava来获取用户信息并对信息做进一步的处理
         */
        Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<User> emitter) throws Throwable {
                view.showProgress();
                emitter.onNext(getUserInfo());
            }
        }).map(new Function<User, String>() {
            @Override
            public String apply(User user) throws Throwable {
                return "name = " + user.getName()
                        + ",age = " + user.getAge()
                        + ",sex = " + user.getSex();
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                Log.d(TAG, "accept: load finished, info = " + s);
                view.hideProgress();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {
                Log.d(TAG, "accept: 获取用户信息失败");
                view.hideProgress();
            }
        });
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public User getUserInfo() {
        FindInformation.findUserInfo("张四", new Callback() {
            @Override
            public void success(User user) {
                userInfo = user;
            }

            @Override
            public void failed(String error) {
                Log.d(TAG, "failed: " + error);
            }
        });
        return userInfo;
    }

    /**
     * 回调接口
     */
    public interface Callback {
        void success(User user);

        void failed(String error);
    }
}
