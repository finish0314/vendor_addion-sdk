package com.android.settings.custom.gesture;

import android.os.Bundle;

import com.android.settings.custom.R;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragment;

import com.android.internal.custom.hardware.LineageHardwareManager;

public class GestureSettings extends PreferenceFragment {
    private static final String TOUCHSCREEN_GESTURES_PREF = "touchscreen_gesture_settings";
    private LineageHardwareManager mHardware;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.gesture_settings);

        final Preference touchscreenGesturesPref =
                (Preference) getPreferenceScreen().findPreference(TOUCHSCREEN_GESTURES_PREF);

        mHardware = LineageHardwareManager.getInstance(getActivity());
        if (!mHardware.isSupported(LineageHardwareManager.FEATURE_TOUCHSCREEN_GESTURES)){
            getPreferenceScreen().removePreference(touchscreenGesturesPref);
        }
    }
}
