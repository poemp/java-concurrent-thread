package org.poem.concurrent.exchange;

import org.poem.concurrent.exchange.entity.ExchangerRunnable;

public class Exchanger {
    public static void main(String[] args) {
        java.util.concurrent.Exchanger exchanger = new java.util.concurrent.Exchanger();

        ExchangerRunnable exchangerRunnable = new ExchangerRunnable(exchanger, "A");

        ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger,"B");

        new Thread(exchangerRunnable).start();
        new Thread(exchangerRunnable1).start();
    }
}
