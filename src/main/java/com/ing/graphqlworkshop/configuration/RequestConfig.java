package com.ing.graphqlworkshop.configuration;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;

import static com.ing.graphqlworkshop.configuration.HttpClientConfigConstants.*;

public class RequestConfig {

    @Bean
    public CloseableHttpClient httpClient() {
        org.apache.http.client.config.RequestConfig requestConfig = org.apache.http.client.config.RequestConfig.custom()
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();

        return HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
//                .setConnectionManager(poolingConnectionManager())
//                .setKeepAliveStrategy(connectionKeepAliveStrategy())
                .build();
    }

}
