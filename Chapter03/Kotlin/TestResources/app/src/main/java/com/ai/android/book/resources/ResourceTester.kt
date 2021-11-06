package com.ai.android.book.resources

import android.content.Context
import org.xmlpull.v1.XmlPullParser
import java.io.ByteArrayOutputStream
import java.io.InputStream

class ResourceTester(
    ctx: Context,
    target: IReportBack
): BaseTester(target, ctx) {

    public fun testEnStrings() {
        var msg = "available in all en/us/root/port/en_port: test_en_us"
        reportString(msg, R.string.teststring_all)
        // The one in file _port is not picked up
        // The precedence is given to the en_us over _port and also over en_port

        msg = "available in only root/en and port: t1_enport"
        reportString(msg, R.string.t1_enport)
        // t1 is in en and port at a parallel level
        // The one in file _port is not picked up
        // The precedence is given to the file in en
        // if you have "t1" in values_en_port, then that will be picked up

        msg = "available in only root/en/port: t1_en_port"
        reportString(msg, R.string.t1_1_en_port)
        // Value from _en_port will be picked up
        // value from _port ignored
        // value from _en ignored

        msg = "available in only root: t2"
        reportString(msg, R.string.t2)

        msg = "available in only port/root: testport_port"
        reportString(msg, R.string.testport_port)
        // this shows that the _port directory is considered
        // even though there are other directories with a
        // higher precedence
    }

    public fun testStringArray() {
        reportArray(R.array.test_array)
    }

    public fun testPlurals() {
        reportPlural(R.plurals.test_plurals, 0)
        reportPlural(R.plurals.test_plurals, 1)
        reportPlural(R.plurals.test_plurals, 2)
        reportPlural(R.plurals.test_plurals, 3)
    }

    private fun reportPlural(plural_id: Int, amount: Int) {
        val res = mContext.resources
        val s = res.getQuantityString(plural_id, amount)
        mReportTo.reportBack(tag, s)
    }

    private fun reportArray(arrayId: Int) {
        val res = mContext.resources
        val strings = res.getStringArray(arrayId)
        for (s in strings) {
            mReportTo.reportBack(tag, s)
        }
    }

    public fun testColor() {
        val res = mContext.resources
        val mainBackGroundColor = res.getColor(R.color.main_back_ground_color)
        reportString("mainBackGroundColor: $mainBackGroundColor")
    }

    public fun testDimensions() {
        val res = mContext.resources
        reportString("dimen: " + res.getDimension(R.dimen.medium_size))
        reportString("dimen: " + res.getDimension(R.dimen.mysize_in_dp))
        reportString("dimen: " + res.getDimension(R.dimen.mysize_in_pixels))
    }

    public fun testStringVariations() {
        // Read a simple string and set it in a text view
        val simpleString = mContext.getString(R.string.simple_string)
        reportString(simpleString)

        // Read a quoted string and set it in a text view
        val quotedString = mContext.getString(R.string.quoted_string)
        reportString(quotedString)

        // Read a double quoted string and set it in a text view
        val doubleQuotedString = mContext.getString(R.string.double_quoted_string)
        reportString(doubleQuotedString)

        // Read a Java format string
        val javaFormatString = mContext.getString(R.string.java_format_string)
        // Convert the formatted string by passing in arguments
        val substitutedString = String.format(javaFormatString, "Hello", "Android")
        // set the output in a text view
        reportString(substitutedString)

        // Read an html string from the resource and set it in a text view
        val htmlTaggedString = mContext.getString(R.string.tagged_string)
        // Convert it to a text span so that it can be set in a text view
        // android.text.Html class allows painting of "html" strings
        // This is strictly an Android class and does not support all html tags
        val textSpan = android.text.Html.fromHtml(htmlTaggedString)
        // Set it in a text view
        // this.getTextView().text = textSpan
    }

    private fun report(stringId: Int) {
        mReportTo.reportBack(tag, mContext.getString(stringId))
    }

    private fun reportString(s: String) {
        mReportTo.reportBack(tag, s)
    }

    private fun reportString(s: String, stringId: Int) {
        mReportTo.reportBack(tag, s)
        report(stringId)
    }

    public fun testXML() {
        try {
            val x = getEventsFromAnXMLFile(mContext)
            reportString(x)
        } catch (t: Throwable) {
            reportString("error reading xml file: ${t.message}")
        }
    }

    private fun getEventsFromAnXMLFile(activity: Context): String {
        val sb = StringBuffer()
        val xpp = activity.resources.getXml(R.xml.test)

        xpp.next()
        while (xpp.eventType != XmlPullParser.END_DOCUMENT) {
            when (xpp.eventType) {
                XmlPullParser.START_DOCUMENT -> sb.append("******Start document")
                XmlPullParser.START_TAG -> sb.append("\nStart tag ${xpp.name}")
                XmlPullParser.END_TAG -> sb.append("\nEnd tag ${xpp.name}")
                XmlPullParser.TEXT -> sb.append("\nText ${xpp.text}")
            }
            xpp.next()
        }   // eof-while
        sb.append("\n******End document")
        return sb.toString()
    }   // eof-function

    public fun testRawFile() {
        try {
            val s = getStringFromRawFile(mContext)
            reportString(s)
        } catch (t: Throwable) {
            reportString("error: ${t.message}")
        }
    }

    private fun getStringFromRawFile(activity: Context): String {
        val inputStream = activity.resources.openRawResource(R.raw.test)
        val myText = convertStreamToString(inputStream)
        inputStream.close()
        return myText
    }

    private fun convertStreamToString(inputStream: InputStream): String {
        val baos = ByteArrayOutputStream()
        var i = inputStream.read()
        while (i != -1) {
            baos.write(i)
            i = inputStream.read()
        }
        return baos.toString()
    }

    public fun testAssets() {
        try {
            val s = getStringFromAssetFile(mContext)
            reportString(s)
        } catch (t: Throwable) {
            reportString("error: ${t.message}")
        }
    }

    // Note: Exceptions are not shown in the code
    public fun getStringFromAssetFile(activity: Context): String {
        val inputStream = activity.assets.open("test.txt")
        val s = convertStreamToString(inputStream)
        inputStream.close()
        return s
    }

    companion object {
        const val tag = "ResourceTester"
    }
}