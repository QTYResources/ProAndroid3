package com.ai.android.testintents

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

        public fun invokePick(activity: Activity) {
            val pickIntent = Intent(Intent.ACTION_PICK)
            // pickIntent.data = Contacts.CONTENT_URI
            pickIntent.data = Uri.parse("content://com.google.provider.NotePad/notes")
            activity.startActivityForResult(pickIntent, 1)
        }

        public fun invokeGetContent(activity: Activity) {
            val pickIntent = Intent(Intent.ACTION_GET_CONTENT)
            pickIntent.type = "vnd.android.cursor.item/vnd.google.note"
            activity.startActivityForResult(pickIntent, 2)
        }

        public fun parseResult(activity: MainActivity
            , requestCode: Int
            , resultCode: Int
            , outputIntent: Intent) {
            activity.appendText("parseResult called")
            if (resultCode != Activity.RESULT_OK) {
                activity.appendText("Result code is not ok: $resultCode")
                return
            }

            if (requestCode == 1) {
                parseResultForPick(activity, requestCode, resultCode, outputIntent)
            } else if (requestCode == 2) {
                parseResultForContent(activity, requestCode, resultCode, outputIntent)
            } else {
                activity.appendText("Wrong request code: $requestCode")
            }
        }

        public fun parseResultForPick(activity: MainActivity,
            requestCode: Int,
            resultCode: Int,
            outputIntent: Intent) {
            activity.appendText("parseResult called for pick")
            activity.appendText("Result code is ok: $resultCode")
            activity.appendText("The output uri: ")
            activity.appendText(outputIntent.data.toString())
        }

        public fun parseResultForContent(activity: MainActivity,
            requestCode: Int,
            resultCode: Int,
            outputIntent: Intent) {
            activity.appendText("parseResult called for pick")
            activity.appendText("Result code is ok: $resultCode")
            activity.appendText("The output uri: ")
            activity.appendText(outputIntent.data.toString())
        }

        public fun tryOneOfThese(activity: Activity) {
            IntentsUtils.call(activity)
        }

    }

}