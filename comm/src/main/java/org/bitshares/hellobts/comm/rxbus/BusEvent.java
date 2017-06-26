package org.bitshares.hellobts.comm.rxbus;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yanjuegong on 2017/5/18.
 * email:644613693@qq.com
 */

public class BusEvent implements Parcelable{

    int fromId;
    //事件ID，用于区别事件，事件的命名有响应的规律，一般为4位
    //依次为 modul,eventId 分别两位

    //这是一个唯一值,通常生成时间，为了标记同一个方法在不同时间的调用
    int unique;

    int toId;
    //推荐使用json来传递
    //注意 这个值未序列化！！！！
    Object content;

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public int getUnique() {
        return unique;
    }

    public void setUnique(int unique) {
        this.unique = unique;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.fromId);
        dest.writeInt(this.toId);
        dest.writeInt(this.unique);
    }

    public BusEvent() {
    }

    protected BusEvent(Parcel in) {
        this.fromId = in.readInt();
        this.toId = in.readInt();
        this.unique = in.readInt();
    }

    public static final Creator<BusEvent> CREATOR = new Creator<BusEvent>() {
        @Override
        public BusEvent createFromParcel(Parcel source) {
            return new BusEvent(source);
        }

        @Override
        public BusEvent[] newArray(int size) {
            return new BusEvent[size];
        }
    };
}
