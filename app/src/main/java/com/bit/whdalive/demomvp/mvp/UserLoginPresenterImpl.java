package com.bit.whdalive.demomvp.mvp;

import android.os.Handler;

public class UserLoginPresenterImpl implements IUserLoginPresenter,IUserModel.OnLoginListener {

    private IUserLoginView mIUserLoginView;
    private IUserModel mIUserModel;

    private Handler mHandler = new Handler();

    public UserLoginPresenterImpl(IUserLoginView IUserLoginView) {
        mIUserLoginView = IUserLoginView;
        mIUserModel = new UserModelImpl(this);
    }

    @Override
    public void doLogin() {
        String username = mIUserLoginView.getUserName();
        String password = mIUserLoginView.getPassword();
        mIUserLoginView.showLoading();
        mIUserModel.login(username,password,this);
    }

    @Override
    public void loginSuccess() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mIUserLoginView.hideLoading();
                mIUserLoginView.toMainActivity();
            }
        });
    }

    @Override
    public void loginFailed() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mIUserLoginView.hideLoading();
                mIUserLoginView.showFailedError();
            }
        });

    }

    @Override
    public void clear() {
        mIUserLoginView.clearUserName();
        mIUserLoginView.clearPassword();
    }
}
