package com.androidbook.services.httpget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import java.io.BufferedReader
import java.io.InputStreamReader

@Suppress("DEPRECATION")
class HttpGetDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Thread {
            getRequest()
        }.start()
    }

    private fun getRequest() {
        val client = DefaultHttpClient()
        val request = HttpGet("http://www.baidu.com")
        val response = client.execute(request)
        val br = BufferedReader(InputStreamReader(response.entity.content))

        val sb = StringBuffer("")
        val nl = System.getProperty("line.separator")

        var line:String? = br.readLine()
        while (line != null) {
            sb.append(line + nl)
            line = br.readLine()
        }
        br.close()

        val page = sb.toString()
        Log.d(TAG, "getRequest=>page: \n$page")
    }

    companion object {
        const val TAG = "HttpGetDemo"
    }

}