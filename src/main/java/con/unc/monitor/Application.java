package con.unc.monitor;

import con.unc.monitor.model.SystemModule;

public class Application {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SystemModule(1));

        t1.start();
    }
}
