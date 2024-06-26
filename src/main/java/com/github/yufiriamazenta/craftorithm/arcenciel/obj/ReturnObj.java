package com.github.yufiriamazenta.craftorithm.arcenciel.obj;

public class ReturnObj<T> {

    private ArcencielSignal signal;
    private T obj;

    public ReturnObj() {
        this(ArcencielSignal.END, null);
    }

    public ReturnObj(ArcencielSignal signal) {
        this(signal, null);
    }

    public ReturnObj(T obj) {
        this(ArcencielSignal.CONTINUE, obj);
    }

    public ReturnObj(ArcencielSignal signal, T obj) {
        this.signal = signal;
        this.obj = obj;
    }

    public ArcencielSignal signal() {
        return signal;
    }

    public void setSignal(ArcencielSignal signal) {
        this.signal = signal;
    }

    public T obj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

}
