package com.iie.model.enums;

/**
 * Created by dev on 7/28/2014.
 */
public enum AppName
{
    XTIGHTVNC("Xtightvnc"),
    MINIDLNA("Minidlna"),
    OPENVPN("OpenVpn"),
    TRANSMISSIONGUI("TransmissionGUI");

    private String appName;

    AppName(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }
}
