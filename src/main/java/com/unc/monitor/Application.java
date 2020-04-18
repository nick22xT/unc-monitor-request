package com.unc.monitor;

import com.unc.monitor.model.SystemModule;

public class Application {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SystemModule(1));

        t1.start();
    }
}
