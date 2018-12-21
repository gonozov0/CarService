package ru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class CSService {

    private Config config;
    private String localPath;

    @PostConstruct
    public void init() {
        localPath = "http://localhost:";
        config = new Config("http://localhost:8081/", "http://localhost:8082/", "http://localhost:8083/", "http://localhost:8084/");
    }

    public Config getConfig() {
        return config;
    }
}
