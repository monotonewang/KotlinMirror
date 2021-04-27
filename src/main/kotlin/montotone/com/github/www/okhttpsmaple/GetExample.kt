package montotone.com.github.www.okhttpsmaple


import java.io.IOException
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

/**
 * okhttp GetEample
 */
class GetExample {
    internal var client = OkHttpClient()

    @Throws(IOException::class)
    internal fun run(url: String): String {
        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).execute().use({ response -> return response.body()!!.string() })
    }

    companion object {

        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {

            val url="http://wxpay.wxutil.com/pub_v2/app/app_pay.php"
            val example = GetExample()
//            val response = example.run("https://raw.github.com/square/okhttp/master/README.md")
            val response = example.run(url)
            println(response)
        }
    }
}