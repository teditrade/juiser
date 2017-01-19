package com.stormpath.juiser.model;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.TimeZone;

public abstract class ResolvingUser implements User {

    protected abstract User findUser();

    private User getRequiredUser() {
        User user = findUser();
        if (user == null) {
            String msg = "Unable to acquire required " + User.class.getName() +
                " instance from the current " + getClass().getName() + " runtime context.";
            throw new IllegalStateException(msg);
        }
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return findUser() != null;
    }

    @Override
    public boolean isAnonymous() {
        return !isAuthenticated();
    }

    @Override
    public String getHref() {
        return isAnonymous() ? null : getRequiredUser().getHref();
    }

    @Override
    public String getId() {
        return isAnonymous() ? null : getRequiredUser().getId();
    }

    @Override
    public String getName() {
        return isAnonymous() ? null : getRequiredUser().getName();
    }

    @Override
    public String getGivenName() {
        return isAnonymous() ? null : getRequiredUser().getGivenName();
    }

    @Override
    public String getFamilyName() {
        return isAnonymous() ? null : getRequiredUser().getFamilyName();
    }

    @Override
    public String getMiddleName() {
        return isAnonymous() ? null : getRequiredUser().getMiddleName();
    }

    @Override
    public String getNickname() {
        return isAnonymous() ? null : getRequiredUser().getNickname();
    }

    @Override
    public String getUsername() {
        return isAnonymous() ? null : getRequiredUser().getUsername();
    }

    @Override
    public URL getProfile() {
        return isAnonymous() ? null : getRequiredUser().getProfile();
    }

    @Override
    public URL getPicture() {
        return isAnonymous() ? null : getRequiredUser().getPicture();
    }

    @Override
    public URL getWebsite() {
        return isAnonymous() ? null : getRequiredUser().getWebsite();
    }

    @Override
    public String getEmail() {
        return isAnonymous() ? null : getRequiredUser().getEmail();
    }

    @Override
    public boolean isEmailVerified() {
        return isAuthenticated() && getRequiredUser().isEmailVerified();
    }

    @Override
    public String getGender() {
        return isAnonymous() ? null : getRequiredUser().getGender();
    }

    @Override
    public LocalDate getBirthdate() {
        return isAnonymous() ? null : getRequiredUser().getBirthdate();
    }

    @Override
    public TimeZone getZoneInfo() {
        return isAnonymous() ? null : getRequiredUser().getZoneInfo();
    }

    @Override
    public Locale getLocale() {
        return isAnonymous() ? null : getRequiredUser().getLocale();
    }

    @Override
    public Phone getPhone() {
        return isAnonymous() ? null : getRequiredUser().getPhone();
    }

    @Override
    public String getPhoneNumber() {
        return isAnonymous() ? null : getRequiredUser().getPhoneNumber();
    }

    @Override
    public boolean isPhoneNumberVerified() {
        return isAuthenticated() && getRequiredUser().isPhoneNumberVerified();
    }

    @Override
    public ZonedDateTime getCreatedAt() {
        return isAnonymous() ? null : getRequiredUser().getCreatedAt();
    }

    @Override
    public ZonedDateTime getUpdatedAt() {
        return isAnonymous() ? null : getRequiredUser().getUpdatedAt();
    }
}
