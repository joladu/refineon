package com.jola.refineframe.contract.main;

import com.jola.refineframe.base.presenter.AbstractPresenter;
import com.jola.refineframe.base.view.AbstractView;



public interface LoginContract {

    interface View extends AbstractView {

        /**
         * Show login data
         *
         */
        void showLoginSuccess();
    }

    interface Presenter extends AbstractPresenter<View> {

        /**
         * Get Login data
         *
         * @param username user name
         * @param password password
         */
        void getLoginData(String username, String password);
    }



}
