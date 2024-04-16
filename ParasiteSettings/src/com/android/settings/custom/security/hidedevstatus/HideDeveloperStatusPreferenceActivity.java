/*
 * Copyright (C) 2019 The PixelExperience Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.custom.security.hidedevstatus;

import android.content.Context;
import android.content.pm.UserInfo;
import android.provider.Settings;
import android.os.Bundle;
import android.os.UserManager;

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity;
import com.android.settingslib.collapsingtoolbar.R;

import com.android.internal.util.custom.HideDeveloperStatusUtils;

import java.util.List;

public class HideDeveloperStatusPreferenceActivity extends CollapsingToolbarBaseActivity {

    private static final String TAG = "hide_developer_status_settings";
    private static HideDeveloperStatusUtils hideDeveloperStatusUtils = new HideDeveloperStatusUtils();

    private UserManager userManager;
    private List<UserInfo> userInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userManager = UserManager.get(getApplicationContext());
        userInfos = userManager.getUsers();
        for (UserInfo info: userInfos) {
            hideDeveloperStatusUtils.setApps(getApplicationContext(), info.id);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                new HideDeveloperStatusSettings(), TAG)
                .commit();
    }
}
