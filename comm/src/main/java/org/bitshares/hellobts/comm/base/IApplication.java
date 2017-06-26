package org.bitshares.hellobts.comm.base;

import android.content.Context;

/**
 * Created by user on 2017/6/12.
 */

public interface IApplication {
    void attachBaseContext(Context base);
    void onCreate(Context context);

}
