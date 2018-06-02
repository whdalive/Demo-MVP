package com.bit.whdalive.demomvp.mvp;

import com.bit.whdalive.demomvp.bean.User;

public class UserModelImpl implements IUserModel{

    private IUserLoginPresenter mIUserLoginPresenter;

    public UserModelImpl(IUserLoginPresenter IUserLoginPresenter) {
        mIUserLoginPresenter = IUserLoginPresenter;
    }

    @Override
    public void login(final String username, final String password,final IUserModel.OnLoginListener listener) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if("whdalive".equals(username)&&"123...".equals(password)){
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    listener.loginSuccess();
                }else{
                    listener.loginFailed();
                }
            }
        }.start();
    }
}
