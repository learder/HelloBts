package org.bitshares.hellobts.login.debug;

import org.bitshares.hellobts.comm.base.BaseApp;
import org.bitshares.hellobts.login.LoginApplication;

/**
 * Created by 颜厥共 on 2017/6/26.
 * mail:644613693@qq.com
 */

public class TestLoginApplication extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        addIApplication(new LoginApplication());
    }
}
