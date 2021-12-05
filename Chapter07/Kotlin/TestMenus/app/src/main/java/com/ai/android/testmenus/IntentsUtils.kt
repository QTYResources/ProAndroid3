package com.ai.android.testmenus

import android.app.Activity
import android.content.Intent
import android.net.Uri

class IntentsUtils {

    companion object {

        public fun invokeBasicActivity(activity: Activity) {
            val actionName = "com.androidbook.intent.action.ShowBasicView"
            val intent = Intent(actionName)
            activity.startActivity(intent)
        }

        public fun invokeWebBrowser(activity: Activity) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://www.baidu.com")
            activity.startActivity(intent)
        }

        public fun invokeWebSearch(activity: Activity) {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.data = Uri.parse("http://www.google.com")
            activity.startActivity(intent)
        }

        public fun dial(activity: Activity) {
            val intent = Intent(Intent.ACTION_DIAL)
            activity.startActivity(intent)
        }

        public fun call(activity: Activity) {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:904-905-5646")
            activity.startActivity(intent)
        }

        public fun showMapAtLatLong(activity: Activity) {
            val intent = Intent(Intent.ACTION_VIEW)
            // geo:lat,long?z=zoomlevel&q=question-string
            intent.data = Uri.parse("geo:0,0?z=4&q=business+near+city")
            activity.startActivity(intent)
        }

        public fun tryOneOfThese(activity: Activity) {
            IntentsUtils.call(activity)
        }

    }

}