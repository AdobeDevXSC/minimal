package com.adobe.aem.xsc.core.components;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface EmbedServerSide {

    String getApiUrl();

    String getResults();

    boolean isReady();
}