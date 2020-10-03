package com.android.settings.custom.display;

import android.os.Bundle;

import com.android.settings.custom.R;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragment;

import com.android.internal.util.custom.cutout.CutoutFullscreenController;

public class DisplaySettings extends PreferenceFragment {
    private static final String CUTOUT_FROCE_FULL_SCREEN_PREF = "display_cutout_force_fullscreen_settings";
    private CutoutFullscreenController mCutoutForceFullscreenSettings;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.display_settings);

        mCutoutForceFullscreenSettings = new CutoutFullscreenController(getContext());

        final Preference displayCutoutForceFullScreenPref =
                (Preference) getPreferenceScreen().findPreference(CUTOUT_FROCE_FULL_SCREEN_PREF);

        if (!mCutoutForceFullscreenSettings.isSupported()) {
            getPreferenceScreen().removePreference(displayCutoutForceFullScreenPref);
        }
    }
}
