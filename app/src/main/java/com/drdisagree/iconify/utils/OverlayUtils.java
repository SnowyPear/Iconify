package com.drdisagree.iconify.utils;

import android.util.Log;

import com.drdisagree.iconify.Iconify;
import com.drdisagree.iconify.config.PrefConfig;
import com.topjohnwu.superuser.Shell;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OverlayUtils {

    public static List<String> getOverlayList() {
        return Shell.cmd("cmd overlay list |  grep -E '^....IconifyComponent' | sed -E 's/^....//'").exec().getOut();
    }

    public static List<String> getEnabledOverlayList() {
        return Shell.cmd("cmd overlay list |  grep -E '^.x..IconifyComponent' | sed -E 's/^.x..//'").exec().getOut();
    }

    public static List<String> getDisabledOverlayList() {
        return Shell.cmd("cmd overlay list |  grep -E '^. ..IconifyComponent' | sed -E 's/^. ..//'").exec().getOut();
    }

    public static boolean isOverlayEnabled(List<String> overlays, String pkgName) {
        for (String overlay : overlays) {
            if (overlay.equals(pkgName))
                return true;
        }
        return false;
    }

    public static boolean isOverlayDisabled(List<String> overlays, String pkgName) {
        for (String overlay : overlays) {
            if (overlay.equals(pkgName))
                return false;
        }
        return true;
    }

    static boolean isOverlayInstalled(List<String> enabledOverlays, String pkgName) {
        for (String line : enabledOverlays) {
            if (line.equals(pkgName))
                return true;
        }
        return false;
    }

    public static void enableOverlay(String pkgName) {
        Shell.cmd("cmd overlay enable --user current " + pkgName, "cmd overlay set-priority " + pkgName + " highest").exec();
        PrefConfig.savePrefBool(Iconify.getAppContext(), pkgName, true);
    }

    public static void disableOverlay(String pkgName) {
        Shell.cmd("cmd overlay disable --user current " + pkgName).exec();
        PrefConfig.savePrefBool(Iconify.getAppContext(), pkgName, false);
    }

    public static boolean overlayExists() {
        try {
            String[] packages = Iconify.getAppContext().getAssets().list("Overlays");
            int numberOfOverlaysInAssets = 0;

            for (String overlay : packages) {
                numberOfOverlaysInAssets += Iconify.getAppContext().getAssets().list("Overlays/" + overlay).length;
            }

            int numberOfOverlaysInstalled = Integer.parseInt(Shell.cmd("find /" + ModuleUtil.OVERLAY_DIR + "/ -maxdepth 1 -type f -print| wc -l").exec().getOut().get(0));
            Log.e("OverlayExists", String.valueOf(numberOfOverlaysInAssets) + ' ' + numberOfOverlaysInstalled);
            return numberOfOverlaysInAssets == numberOfOverlaysInstalled;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
