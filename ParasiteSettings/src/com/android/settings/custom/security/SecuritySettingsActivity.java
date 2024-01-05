package com.android.settings.custom.security;

import android.os.Bundle;

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity;
import com.android.settingslib.widget.R;

public class SecuritySettingsActivity extends CollapsingToolbarBaseActivity {

    private static final String TAG = "security_settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(R.id.content_frame,
                new SecuritySettings(), TAG)
                .commit();
    }
}
