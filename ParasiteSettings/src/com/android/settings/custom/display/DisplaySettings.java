package com.android.settings.custom.display;

import android.os.Bundle;

import com.android.settings.custom.R;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragment;

import com.android.internal.custom.hardware.LineageHardwareManager;
import com.android.internal.util.custom.cutout.CutoutFullscreenController;

public class DisplaySettings extends PreferenceFragment {
    private static final String CUTOUT_FROCE_FULL_SCREEN_PREF = "display_cutout_force_fullscreen_settings";
    private CutoutFullscreenController mCutoutForceFullscreenSettings;

    private static final String KEY_HIGH_TOUCH_POLLING_RATE = "high_touch_polling_rate_enable";
    private static final String KEY_HIGH_TOUCH_SENSITIVITY = "high_touch_sensitivity_enable";
    private static final String KEY_TOUCH_HOVERING = "feature_touch_hovering";
    private LineageHardwareManager mHardware;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.display_settings);

        final Preference highTouchPollingRatePref =
                (Preference) getPreferenceScreen().findPreference(KEY_HIGH_TOUCH_POLLING_RATE);
        final Preference highTouchSensitivityPref =
                (Preference) getPreferenceScreen().findPreference(KEY_HIGH_TOUCH_SENSITIVITY);
        final Preference touchHoveringPref =
                (Preference) getPreferenceScreen().findPreference(KEY_TOUCH_HOVERING);

        mHardware = LineageHardwareManager.getInstance(getActivity());

        if (!mHardware.isSupported(LineageHardwareManager.FEATURE_HIGH_TOUCH_POLLING_RATE)){
            getPreferenceScreen().removePreference(highTouchPollingRatePref);
        }
        if (!mHardware.isSupported(LineageHardwareManager.FEATURE_HIGH_TOUCH_SENSITIVITY)){
            getPreferenceScreen().removePreference(highTouchSensitivityPref);
        }
        if (!mHardware.isSupported(LineageHardwareManager.FEATURE_TOUCH_HOVERING)){
            getPreferenceScreen().removePreference(touchHoveringPref);
        }

        mCutoutForceFullscreenSettings = new CutoutFullscreenController(getContext());

        final Preference displayCutoutForceFullScreenPref =
                (Preference) getPreferenceScreen().findPreference(CUTOUT_FROCE_FULL_SCREEN_PREF);

        if (!mCutoutForceFullscreenSettings.isSupported()) {
            getPreferenceScreen().removePreference(displayCutoutForceFullScreenPref);
        }
    }
}
