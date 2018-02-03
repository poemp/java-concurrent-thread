package org.poem.concurrent.exchange.entity;


import java.util.concurrent.Exchanger;

import static java.lang.System.err;

public class ExchangerRunnable implements Runnable {
    Exchanger exchanger = null;
    private Object object = null;
    public ExchangerRunnable(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }
    public void run() {
        try{
            Object o = this.object;
            this.object = this.exchanger.exchange(this.object);
            err.println(Thread.currentThread().getName() + " exchange " + o + " for " + this.object);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
