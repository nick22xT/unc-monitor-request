package con.unc.monitor.request;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MonitorRequest {

    private static final String URL = "http://25.43.154.39:9090/unc-monitor-system%s";
    private RestTemplate restTemplate = new RestTemplate();

    public MonitorRequest() {
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(converters);
    }

    public ResponseEntity<Boolean> getResponse(Map<String, String> request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAll(request);

        return restTemplate.exchange(String.format(URL, "/executeMonitor/time"), HttpMethod.GET,
                new HttpEntity(headers), Boolean.class);
    }

}
