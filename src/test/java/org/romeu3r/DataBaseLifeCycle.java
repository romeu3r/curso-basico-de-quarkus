package org.romeu3r;


import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.MySQLContainer;

import java.util.HashMap;
import java.util.Map;

public class DataBaseLifeCycle implements QuarkusTestResourceLifecycleManager {
    private static MySQLContainer<?> sqlContainer = new MySQLContainer<>("mysql:latest");

    @Override
    public Map<String, String> start() {
        sqlContainer.start();
        Map<String, String> propriedades = new HashMap<>();
        propriedades.put("quarkus.datasource.jdbc.url", sqlContainer.getJdbcUrl());
        propriedades.put("quarkus.datasource.username", sqlContainer.getUsername());
        propriedades.put("quarkus.datasource.password", sqlContainer.getPassword());
        return propriedades;
    }

    @Override
    public void stop() {
        if (sqlContainer != null)
            sqlContainer.stop();

    }
}
