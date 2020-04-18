package con.unc.monitor.model;

import con.unc.monitor.request.MonitorRequest;

import java.util.HashMap;
import java.util.Map;

public class SystemModule implements Runnable {

    MonitorRequest resClient;
    Integer transition;

    public SystemModule(Integer transition) {
        this.transition = transition;
        this.resClient = new MonitorRequest();
    }

    public void run() {
        Map<String, String> request = new HashMap<String, String>();

        request.put("transition", String.valueOf(transition.intValue()));

        while (true) {
            resClient.getResponse(request);
        }
    }
}
