package com.example.t.mycalculator;

import android.app.Application;
import android.content.Context;

/**
 * Created by T on 2015-12-01.
 */
public class CalculatorApplication extends Application {
    private static Context mcalContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mcalContext = this;
    }

    public static Context getContext(){
        return  mcalContext;
    }

}
