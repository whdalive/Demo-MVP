package com.bit.whdalive.demomvp.mvp;

public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity();

    void showFailedError();

}
