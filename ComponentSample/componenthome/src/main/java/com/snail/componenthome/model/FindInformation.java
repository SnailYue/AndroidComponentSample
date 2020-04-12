package com.snail.componenthome.model;

import com.snail.componenthome.bean.User;
import com.snail.componenthome.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

public class FindInformation {
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("张三", 21, "男"));
        userList.add(new User("李四", 22, "男"));
        userList.add(new User("王五", 23, "男"));
        userList.add(new User("小红", 18, "女"));
    }

    /**
     * 查找指定用户的信息，并通过回调返回用户的信息
     *
     * @param name
     * @param callback
     */
    public static void findUserInfo(String name, HomePresenter.Callback callback) {
        User user = searchUserInfo(name);
        if (user.getName().isEmpty()) {
            callback.failed("没有获取到用户信息");
        } else {
            callback.success(user);
        }
    }

    /**
     * 根据用户名搜索该用户
     *
     * @param name
     * @return
     */
    public static User searchUserInfo(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return new User();
    }
}
