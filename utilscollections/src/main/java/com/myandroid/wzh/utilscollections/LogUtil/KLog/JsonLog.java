package com.myandroid.wzh.utilscollections.LogUtil.KLog;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author W.Z.H
 * @time 2018/6/11 14:55
 * @description
 */
public class JsonLog {
    public static void printJson(String tag, String msg, String headString) {

        String message;

        try {
            if (msg.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(KLog.JSON_INDENT);
            } else if (msg.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(KLog.JSON_INDENT);
            } else {
                message = msg;
            }
        } catch (JSONException e) {
            message = msg;
        }

        KLogUtil.printLine(tag, true);
        message = headString + KLog.LINE_SEPARATOR + message;
        String[] lines = message.split(KLog.LINE_SEPARATOR);
        for (String line : lines) {
            Log.d(tag, "║ " + line);
        }
        KLogUtil.printLine(tag, false);
    }
}
