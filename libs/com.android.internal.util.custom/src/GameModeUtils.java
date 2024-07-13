/*
 * Copyright (C) 2024 TheParasiteProject
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

package com.android.internal.util.custom;

import android.provider.Settings;
import android.provider.DeviceConfig;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameModeUtils {

    private static final String TAG = GameModeUtils.class.getSimpleName();
    private static final boolean DEBUG = false;

    private static final String NAMESPACE = "game_mode_utils";
    private static final String NAME_GAME_CONFIG = "list_and_config";

    public static Map<String, Integer> getGameList() {
        Map<String, Integer> map = new HashMap<>();

        String games = DeviceConfig.getString(NAMESPACE, NAME_GAME_CONFIG, "");

        if (TextUtils.isEmpty(games)) {
            return map;
        }

        String[] pv = games.split(",");
        for (String p : pv) {
            String[] fullKey = p.split("=");

            String packageName = fullKey[0];
            Integer profileValue = Integer.valueOf(fullKey[1]);
            map.put(packageName, profileValue);
        }

        return map;
    }

    public static List<String> getPackageList() {
        return new ArrayList<String>(getGameList().keySet());
    }

    public static void putConfig(Map<String, Integer> map) {
        StringBuilder str = new StringBuilder("");
        for (String key : map.keySet()) {
            str.append(key + "=" + map.get(key) + ",");
        }
        if (str.length() > 0) {
            str.delete(str.length() - 1, str.length());
        }

        final String value = str.toString();

        Settings.Config.putString(NAMESPACE, NAME_GAME_CONFIG, value, false);
    }

    public static void add(String packageName, int gameMode) {
        Map<String, Integer> map = getGameList();
        map.put(packageName, gameMode);
        putConfig(map);
    }

    public static void remove(String packageName) {
        Map<String, Integer> map = getGameList();
        map.remove(packageName);
        putConfig(map);
    }

    public static boolean isGameInList(String packageName, boolean ret) {
        if (getGameList().keySet().contains(packageName)) {
            return true;
        }
        return ret;
    }

    public static int getGameMode(String packageName, int ret) {
        Map<String, Integer> map = getGameList();
        if (map.isEmpty() || !isGameInList(packageName, false)) {
            return ret;
        }

        return map.get(packageName);
    }

    public static void dlog(String msg) {
        if (DEBUG) Log.d(TAG, msg);
    }
}
