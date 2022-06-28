package com.makeniqal.downloader.express;

/**
 * Do not copy this code. Just share this library with credit
 * You can use this in your app without credit.
 * Created by MAKENIQAL
 * 06/02/2022
 * Thank you!
 */

public interface ExpressListener {
    /**
     * An interface that works as Listener
     */
    void onDownloadQueued();
    void onDownloadComplete(String filename);
    void onDownloadFailed(String errorMessage);
}
