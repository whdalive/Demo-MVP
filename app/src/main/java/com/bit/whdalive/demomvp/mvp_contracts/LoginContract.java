package com.bit.whdalive.demomvp.mvp_contracts;

import com.bit.whdalive.demomvp.bean.User;

public interface LoginContract {

    public interface View {

        String getUserName();

        String getPassword();

        void clearUserName();

        void clearPassword();

        void showLoading();

        void hideLoading();

        void toMainActivity();

        void showFailedError();
    }

    public interface Presenter {

        void login();

        void clear();
    }
}
