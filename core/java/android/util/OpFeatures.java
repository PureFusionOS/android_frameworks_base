package android.util;

import java.util.BitSet;

public final class OpFeatures {
    public static final String BACKGROUND_PROCESS_BUSY_DETECTION = "persist.sys.bg_detection";
    private static final String BLACK_MODE_PROP = "persist.sys.blackmode";
    public static final String FEATURE_OEM_BUTTON_LIGHT = "oem.button.light.support";
    public static final String FEATURE_OEM_HARDWARE_ALERT_SLIDER = "oem.hardware.alert.slider";
    public static final String FEATURE_OEM_VIRTUAL_HW_KEY = "oem.virtual.hw.key";
    public static final int OP_FEATURE_APP_BOOT_MANAGER = 0x16;
    public static final int OP_FEATURE_APP_LOCKER = 0x17;
    public static final int OP_FEATURE_AUTO_STARTUP = 0x4;
    public static final int OP_FEATURE_BACK_COVER_THEME = 0x9;
    public static final int OP_FEATURE_BG_DETECTION = 0xe;
    private static final int OP_FEATURE_BIT_BASE = 0x0;
    private static final int OP_FEATURE_BIT_END = 0x1a;
    public static final int OP_FEATURE_BLACK_GESTURE = 0x11;
    public static final int OP_FEATURE_BUGREPORT = 0x3;
    public static final int OP_FEATURE_CHANGE_PACKAGE_NAME = 0x15;
    public static final int OP_FEATURE_CTA_PERMISSION_CONTROL = 0xc;
    public static final int OP_FEATURE_EXT_AUDIO_DECODER = 0x13;
    public static final int OP_FEATURE_GESTURE_SCREENSHOT = 0xd;
    public static final int OP_FEATURE_KEY_LOCK = 0xb;
    public static final int OP_FEATURE_LONG_SCREENSHOT = 0x18;
    public static final int OP_FEATURE_MDM = 0x2;
    public static final int OP_FEATURE_MMS_NOTI_SOUND = 0x6;
    public static final int OP_FEATURE_MULTI_SIM_RINGTONES = 0x7;
    public static final int OP_FEATURE_OP_KEYGUARD = 0x5;
    public static final int OP_FEATURE_POST_INSTALL_AMAZON_APPS = 0x14;
    public static final int OP_FEATURE_QUICK_PAY = 0x1a;
    public static final int OP_FEATURE_RESERVE_APP = 0x12;
    public static final int OP_FEATURE_RINGTONE_ALIAS = 0xf;
    public static final int OP_FEATURE_RINGTONE_BKP = 0x10;
    public static final int OP_FEATURE_SCENE_MODES = 0x19;
    public static final int OP_FEATURE_SKU_CHINA = 0x0;
    public static final int OP_FEATURE_SKU_GLOBAL = 0x1;
    public static final int OP_FEATURE_SWAP_KEYS = 0x8;
    public static final int OP_FEATURE_TRI_STATE_KEY = 0xa;
    private static final BitSet sFeatures = new BitSet(0x1b);

    static {
        sFeatures.set(OP_FEATURE_CHANGE_PACKAGE_NAME);
        sFeatures.set(OP_FEATURE_RESERVE_APP);
        sFeatures.set(OP_FEATURE_SKU_GLOBAL);
        sFeatures.set(OP_FEATURE_POST_INSTALL_AMAZON_APPS);
        sFeatures.set(OP_FEATURE_APP_BOOT_MANAGER);
        sFeatures.set(OP_FEATURE_CTA_PERMISSION_CONTROL);
        sFeatures.set(OP_FEATURE_MDM);
        sFeatures.set(OP_FEATURE_BUGREPORT);
        sFeatures.set(OP_FEATURE_MULTI_SIM_RINGTONES);
        sFeatures.set(OP_FEATURE_MMS_NOTI_SOUND);
        sFeatures.set(OP_FEATURE_SWAP_KEYS);
        sFeatures.set(OP_FEATURE_TRI_STATE_KEY);
        sFeatures.set(OP_FEATURE_KEY_LOCK);
        sFeatures.set(OP_FEATURE_GESTURE_SCREENSHOT);
        sFeatures.set(OP_FEATURE_BLACK_GESTURE);
        sFeatures.set(OP_FEATURE_EXT_AUDIO_DECODER);
        sFeatures.set(OP_FEATURE_APP_LOCKER);
        sFeatures.set(OP_FEATURE_LONG_SCREENSHOT);
        sFeatures.set(OP_FEATURE_BIT_END);
        sFeatures.set(OP_FEATURE_SCENE_MODES);
    }

    public static boolean isSupport(int[] p1) {

    boolean result = true;

/*    for (int feature:p1){

        if((feature < 0) || (feature > 0x1a)) {
         throw new IllegalArgumentException("Invalid required OP feature id: " + feature);
        }

        if(!sFeatures.get(feature)) {
                result=false;
            }
        }
*/
        return result;
    }
    
    public static boolean isBlackModeOn(){
        return true;
    }
}
