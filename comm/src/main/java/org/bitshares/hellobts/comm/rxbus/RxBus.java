package org.bitshares.hellobts.comm.rxbus;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * RxBus
 */
public class RxBus {
    // 主题
    private final Subject<Object> mBus;

    private RxBus() {
        mBus = PublishSubject.create();
    }

    public static RxBus getDefault() {
        return RxBusHolder.sInstance;
    }

    private static class RxBusHolder {
        private static final RxBus sInstance = new RxBus();
    }

    // 提供了一个新的事件
    public void post(Object o) {
        Log.d(getClass().getSimpleName(),"post->"+o.getClass());
        mBus.onNext(o);
    }

    // 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
    public <T> Observable<T> toObservable(Class<T> eventType) {
        Log.d(getClass().getSimpleName(),"toObservable-->"+eventType.getName());
        return mBus.ofType(eventType);
    }

}
