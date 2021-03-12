package app.technic.urentbike.data.utils

import android.app.ProgressDialog
import android.util.Log
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.HashMap
import java.util.concurrent.TimeUnit

class HttpUtil {
//    private val client = OkHttpClient.Builder()
//            .addNetworkInterceptor(StethoInterceptor())
//            .readTimeout(60, TimeUnit.SECONDS)
//            .connectTimeout(60, TimeUnit.SECONDS)
//            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
//            .build()
//    private val builder: Request.Builder? = null
//    private var reqestTag = 0
//    fun httprequestPost(url: String, json_prm: JSONObject, access_token: String, reqestTag: Int, pd: ProgressDialog?, cb: HttpCallback) {
//        var request: Request? = null
//        this.reqestTag = reqestTag
//        Log.d("url->", url)
//        val body = RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), json_prm.toString())
//        request = Request.Builder()
//                .addHeader("Authorization", "Bearer $access_token")
//                .addHeader("Accept-Language", "ru-RU")
//                .url("" + url)
//                .post(body)
//                .build()
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                Log.d("...", "url->" + call.request().url.toString())
//                Log.d("...newCall", "onFailure")
//                cb.onFailure(e)
//            }
//
//            @Throws(IOException::class)
//            override fun onResponse(call: Call, response: Response) {
//                try {
//                    Log.d("httprequestPost", "onResponse->code->" + response.code)
//                    val json = JSONObject(response.body!!.string())
//                    if (!response.isSuccessful) {
//                        cb.onFailure(response, json, reqestTag, null)
//                        return
//                    }
//                    cb.onSuccess(response, json, reqestTag)
//                } catch (e: JSONException) {
//                    cb.onFailure(response, JSONObject(), reqestTag, null)
//                    e.printStackTrace()
//                }
//            }
//        })
//    }
//
//    fun httprequest(url: String?, method: String, params: HashMap<String?, String?>, access_token: String, reqestTag: Int, cb: HttpCallback) {
//        var request: Request? = null
//        this.reqestTag = reqestTag
//        Log.d("url->", url!!)
//        if (method == "POST") {
//            Log.d("...", "httprequest->$params")
//            val builder = FormBody.Builder()
//
//            // Add Params to Builder
//            for ((key, value) in params) {
//                builder.add(key!!, value!!)
//            }
//            val requestBody: RequestBody = builder.build()
//            request = Request.Builder()
//                    .addHeader("Authorization", "Bearer $access_token") //                    .addHeader("Accept-Language","ru-RU")
//                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
//                    .url(url)
//                    .post(requestBody)
//                    .build()
//            client.newCall(request).enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    Log.d("...", "url->" + call.request().url.toString())
//                    Log.d("...newCall", "onFailure" + e.message)
//                    cb.onFailure(e)
//                }
//
//                @Throws(IOException::class)
//                override fun onResponse(call: Call, response: Response) {
//                    try {
//                        Log.d("httprequest", "onResponse->code->" + response.code)
//                        val json = JSONObject(response.body!!.string())
//                        if (!response.isSuccessful) {
//                            cb.onFailure(response, json, reqestTag, null)
//                            return
//                        }
//                        cb.onSuccess(response, json, reqestTag)
//                    } catch (e: JSONException) {
//                        cb.onFailure(response, JSONObject(), reqestTag, null)
//                        e.printStackTrace()
//                    }
//                }
//            })
//        }
//    }
//
//    interface HttpCallback {
//        fun onFailure(e: IOException?)
//        fun onFailure(response: Response?, json: JSONObject?, reqestTag: Int, throwable: Throwable?)
//        fun onSuccess(response: Response?, json: JSONObject?, reqestTag: Int)
//    }
//
//    companion object {
//        var REQEST_TAG_CREDENTUALS = 10001
//        var REQEST_TAG_GETSMSCODE = 10003
//        var REQEST_TAG_SENDSMSCODE = 10005
//        @kotlin.jvm.JvmField
//        var REQEST_TAG_REFRESH = 10008
//    }
}