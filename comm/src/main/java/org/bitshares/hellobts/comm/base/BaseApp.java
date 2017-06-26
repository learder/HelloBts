package org.bitshares.hellobts.comm.base;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 颜厥共 on 2017/6/26.
 * mail:644613693@qq.com
 */

public class BaseApp extends Application {

    List<IApplication> applicationList=new ArrayList<>();

    protected void addIApplication(IApplication iApplication){
        applicationList.add(iApplication);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        for (IApplication application:applicationList){
            application.onCreate(this);
        }
    }

}