package org.bitshares.hellobts.login;

import android.util.Log;

import org.bitshares.hellobts.comm.rxbus.BusEvent;
import org.bitshares.hellobts.comm.rxbus.RxBus;
import org.bitshares.hellobts.comm.rxbus.constants.ConstantLogin;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * Created by 颜厥共 on 2017/6/26.
 * mail:644613693@qq.com
 */

public class LoginRxBus {

    private final String TAG=getClass().getSimpleName();

    private static class LoginRxbusHolder{
        private static final LoginRxBus INSTANCE = new LoginRxBus();
    }

    public static LoginRxBus getInstance(){
        return LoginRxbusHolder.INSTANCE;
    }

    public LoginRxBus() {
//        RxBus.getDefault().toObservable(BusEvent.class)
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext(e-> {
//                    XLog.d(e);
//                });
        RxBus.getDefault().toObservable(BusEvent.class)
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<BusEvent>() {
                    @Override
                    public boolean test(@NonNull BusEvent busEvent) throws Exception {
                        return busEvent.getToId()== ConstantLogin.TEST_MODUL_LOGIN;
                    }
                })
                .doOnNext(new Consumer<BusEvent>() {
                    @Override
                    public void accept(@NonNull BusEvent busEvent) throws Exception {
                        Log.d(TAG,"busEvent");
                    }
                }).subscribe();
    }

}
