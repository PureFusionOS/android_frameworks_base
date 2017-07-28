package android.substratum.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.FileUtils;
import android.os.IBinder;
import android.os.SELinux;
import android.util.Log;

import com.android.internal.substratum.ISubstratumHelperService;

import java.io.File;

public class SubstratumHelperService extends Service {
    private static final String TAG = "SubstratumService";

    private final File EXTERNAL_CACHE_DIR = new File(Environment.getExternalStorageDirectory(), ".substratum");
    private final File SYSTEM_THEME_DIR = new File(Environment.getDataSystemDirectory(), "theme");

    ISubstratumHelperService service = new ISubstratumHelperService.Stub() {
        @Override
        public void applyBootAnimation() {
            File src = new File(EXTERNAL_CACHE_DIR, "bootanimation.zip");
            File dst = new File(SYSTEM_THEME_DIR, "bootanimation.zip");
            int perms = FileUtils.S_IRWXU | FileUtils.S_IRGRP | FileUtils.S_IROTH;

            if (dst.exists()) dst.delete();
            FileUtils.copyFile(src, dst);
            FileUtils.setPermissions(dst, perms, -1, -1);
            SELinux.restorecon(dst);
            src.delete();
        }

        @Override
        public void applyShutdownAnimation() {
            File src = new File(EXTERNAL_CACHE_DIR, "shutdownanimation.zip");
            File dst = new File(SYSTEM_THEME_DIR, "shutdownanimation.zip");
            int perms = FileUtils.S_IRWXU | FileUtils.S_IRGRP | FileUtils.S_IROTH;

            if (dst.exists()) dst.delete();
            FileUtils.copyFile(src, dst);
            FileUtils.setPermissions(dst, perms, -1, -1);
            SELinux.restorecon(dst);
            src.delete();
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return service.asBinder();
    }
}
