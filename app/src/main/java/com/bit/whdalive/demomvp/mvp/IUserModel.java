package com.bit.whdalive.demomvp.mvp;

public interface IUserModel {

    void login(String username,String password,OnLoginListener listener);

    public interface OnLoginListener{

        void loginSuccess();

        void loginFailed();
    }
}
