package com.makeniqal.expresstest

import android.Manifest
import android.content.pm.PackageManager.PERMISSION_DENIED
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.makeniqal.downloader.express.Express
import com.makeniqal.downloader.express.ExpressDownloader
import com.makeniqal.downloader.express.ExpressListener

class MainActivity :AppCompatActivity(){
    private val webview : WebView by lazy { findViewById(R.id.webview) }
    var userAgent= ""
    var contentDisposition=""
    var mimetype=""
    var url = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webview.apply {
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }

        webview.loadUrl("https://www.google.com/search?q=download google drive sample")
        Express.init(this)

        webview.setDownloadListener { url, userAgent, contentDisposition, mimetype, contentLength ->
            this.url = url
            this.userAgent = userAgent
            this.contentDisposition = contentDisposition
            this.mimetype = mimetype
            requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),Express.REQUEST_CODE)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode==8649){

            if (grantResults.isEmpty()||grantResults[0]== PERMISSION_DENIED){
                Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show()
                return
            }


            ExpressDownloader()
                .prepare(userAgent,contentDisposition,mimetype)
                .startDownload(url, object : ExpressListener {
                override fun onDownloadQueued() {
                    Log.d("expressDownloader","downloadQueued")
                }

                override fun onDownloadComplete(filename: String?) {
                    Log.d("expressDownloader","downloadComplete")
                }

                override fun onDownloadFailed(errorMessage: String?) {
                    Log.d("expressDownloader","downloadFailed")
                }
            })
        }

    }

}
