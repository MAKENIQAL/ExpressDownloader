package com.makeniqal.downloader.express;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Environment;
import android.webkit.CookieManager;

import androidx.annotation.Nullable;
/**
 * Do not copy this code. Just share this library with credit
 * You can use this in your app without credit.
 * Created by MAKENIQAL
 * 06/02/2022
 * Thank you!
 */
public class ExpressDownloader {
    /**
     * Store ua,cd and mm
     */
    private String userAgent,contentDisposition,mimeType;
    /**
     * store filename
     */
    protected String filename;
    /**
     * Store, if prepare(...) has called
     */
    private boolean isPrepared = false;
    /**
     * Store the DownloadListener
     */
    protected ExpressListener expressListener;
    /**
     * Store REQUEST_CODE (default value=-1)
     */
    protected long requestCode=-1;

    /**
     * This method helps us to notify that the Downloader is ready to download.
     */
    public ExpressDownloader prepare(@Nullable String userAgent, String contentDisposition, String mimeType){
        this.userAgent = userAgent;
        this.contentDisposition = contentDisposition;
        this.mimeType = mimeType;
        isPrepared = true;
        return this;
    }

    /**
     * Start the download with Listener
     */
    public long startDownload(String url, ExpressListener listener){
        this.expressListener = listener;

        if (!isPrepared){
            throw new RuntimeException("call prepare(...) first.");
        }

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        if (userAgent!=null){
            request.addRequestHeader("User-agent", userAgent);
        }

        filename = ExpressUtils.guessFileName(url,contentDisposition,mimeType);

        request.addRequestHeader("cookie", CookieManager.getInstance().getCookie(url))
                .setTitle(filename)
                .setDescription("Downloading...")
                .setAllowedOverMetered(true)
                .setMimeType(mimeType)
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE|DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        try{
            requestCode = Express.downloadManager.enqueue(request);
            expressListener.onDownloadQueued();
            Express.include(this);
        }catch (Exception e){
            expressListener.onDownloadFailed("Failed to queue download.");
        }
        return requestCode;
    }

}
