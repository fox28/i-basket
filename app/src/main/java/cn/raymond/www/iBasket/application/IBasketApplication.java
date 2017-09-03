package cn.raymond.www.iBasket.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by scorpion on 2017/8/30.
 */

public class IBasketApplication extends Application {
    private static  IBasketApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getInstance() {
        return instance;
    }
}
