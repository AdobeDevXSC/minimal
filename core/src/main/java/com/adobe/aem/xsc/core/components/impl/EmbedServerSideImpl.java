package com.adobe.aem.xsc.core.components.impl;

import com.adobe.aem.xsc.core.components.EmbedServerSide;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {EmbedServerSide.class},
        resourceType = {EmbedServerSideImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class EmbedServerSideImpl implements EmbedServerSide {
    private static final Logger log = LoggerFactory.getLogger(EmbedServerSideImpl.class);

    public static final String RESOURCE_TYPE = "wknd-extended/components/embed-server-side";

    @ValueMapValue
    @Named("jcr:apiurl")
    @Optional
    private String apiUrl;

    private String results = null;

    @Override
    public String getApiUrl() {
        return apiUrl;
    }

    public String getResults() {
        if (results == null) {
            HttpClient client = HttpClient.newBuilder().build();
            URI uri = URI.create(getApiUrl());

            HttpRequest request = HttpRequest.newBuilder().uri(uri).timeout(Duration.ofSeconds(3)).build();

            HttpResponse<String> response = null;
            try {
                // Request the URL
                response = client.send(request, HttpResponse.BodyHandlers.ofString());

                log.debug("HTTP response body: {} ", response.body());
                results = response.body();
            } catch (IOException | InterruptedException e) {
                log.error("Cloud not successfully invoke the API URL: {}", apiUrl);
                // Leave results null, as isReady will return false
            }
        }

        return results;
    }

    @Override
    public boolean isReady() {
        return StringUtils.isNotBlank(getApiUrl()) && StringUtils.isNotBlank(getResults());
    }
}