package com.stormpath.juiser.spring.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

import javax.servlet.DispatcherType;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@ConfigurationProperties("juiser.web.filter")
public class ForwardedUserFilterConfig {

    public static final String DEFAULT_URL_PATTERN = "/*";

    private Set<DispatcherType> dispatcherTypes;

    private boolean enabled;

    private boolean matchAfter;

    private int order;

    private Set<String> requestAttributeNames;

    private Set<String> servletNames;

    private Set<String> urlPatterns;

    public ForwardedUserFilterConfig() {
        this.enabled = true;
        this.matchAfter = false;
        this.order = 10;
        this.dispatcherTypes = new LinkedHashSet<>(Arrays.asList(DispatcherType.values()));
        this.requestAttributeNames = new LinkedHashSet<>(Collections.singletonList("user"));
        this.servletNames = new LinkedHashSet<>();
        this.urlPatterns = new LinkedHashSet<>(Collections.singletonList(DEFAULT_URL_PATTERN));
    }

    public Set<DispatcherType> getDispatcherTypes() {
        return dispatcherTypes;
    }

    public void setDispatcherTypes(Set<DispatcherType> dispatcherTypes) {
        Assert.notNull(dispatcherTypes, "dispatcherTypes cannot be null.");
        this.dispatcherTypes = dispatcherTypes;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isMatchAfter() {
        return matchAfter;
    }

    public void setMatchAfter(boolean matchAfter) {
        this.matchAfter = matchAfter;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }


    public Set<String> getRequestAttributeNames() {
        return requestAttributeNames;
    }

    public void setRequestAttributeNames(Set<String> requestAttributeNames) {
        Assert.notNull(requestAttributeNames, "requestAttributeNames cannot be null.");
        this.requestAttributeNames = requestAttributeNames;
    }

    public Set<String> getServletNames() {
        return servletNames;
    }

    public void setServletNames(Set<String> servletNames) {
        Assert.notNull(servletNames, "servletNames cannot be null.");
        this.servletNames = servletNames;
    }

    public Set<String> getUrlPatterns() {
        return urlPatterns;
    }

    public void setUrlPatterns(Set<String> urlPatterns) {
        Assert.notNull(urlPatterns, "urlPatterns cannot be null.");
        this.urlPatterns = urlPatterns;
    }
}
