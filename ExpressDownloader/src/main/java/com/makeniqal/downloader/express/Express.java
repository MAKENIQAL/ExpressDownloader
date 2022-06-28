package com.makeniqal.downloader.express;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import androidx.core.content.ContextCompat;

/**
 *ExpressDownloader is an open-source library.
 *You can use this in your app.
 *Credit is required if you share this library.
 * ExpressDownloader is system download manager based. (SystemService.DOWNLOAD_SERVICE)
 */

public class Express {
    protected static DownloadManager downloadManager;
    /**
     * Max downloads is 15. Ony 15 downloads can be performed at once. We can perform unlimited downloads one by one
     */
    protected static ExpressDownloader r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15;
    /**
     * An unique request code to identify permission. You can use any request code to handle the permission
     */
    public static int REQUEST_CODE = 5210;

    /**
     * No instance
     */
    private Express() {}

    /**
     * Initialize the DownloadManager and register BroadcastReceiver
     */
    public static void init(Context context) {
        downloadManager = ContextCompat.getSystemService(context, DownloadManager.class);
        context.registerReceiver(broadcastReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    /**
     * protected BroadcastReceiver. BroadcastReceiver helps us to notify DOWNLOAD_COMPLETED
     */
    protected static BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);

            if (r1 != null) {
                if (id == r1.requestCode) {
                    r1.expressListener.onDownloadComplete(r1.filename);
                    r1 = null;
                }
            }

            if (r2 != null) {
                if (id == r2.requestCode) {
                    r2.expressListener.onDownloadComplete(r2.filename);
                    r2 = null;
                }
            }

            if (r3 != null) {
                if (id == r3.requestCode) {
                    r3.expressListener.onDownloadComplete(r3.filename);
                    r3 = null;
                }
            }

            if (r4!=null){
                if (id == r4.requestCode) {
                    r4.expressListener.onDownloadComplete(r4.filename);
                    r4 = null;
                }
            }

            if (r5!=null){
                if (id == r5.requestCode) {
                    r5.expressListener.onDownloadComplete(r5.filename);
                    r5 = null;
                }
            }

            if (r6!=null){
                if (id == r6.requestCode) {
                    r6.expressListener.onDownloadComplete(r6.filename);
                    r6 = null;
                }
            }

            if (r7!=null){
                if (id == r7.requestCode) {
                    r7.expressListener.onDownloadComplete(r7.filename);
                    r7 = null;
                }
            }

            if (r8!=null){
                if (id == r8.requestCode) {
                    r8.expressListener.onDownloadComplete(r8.filename);
                    r8 = null;
                }
            }

            if (r9!=null){
                if (id == r9.requestCode) {
                    r9.expressListener.onDownloadComplete(r9.filename);
                    r9 = null;
                }
            }

            if (r10!=null){
                if (id == r10.requestCode) {
                    r10.expressListener.onDownloadComplete(r10.filename);
                    r10 = null;
                }
            }

            if (r11!=null){
                if (id == r11.requestCode) {
                    r11.expressListener.onDownloadComplete(r11.filename);
                    r11 = null;
                }
            }

            if (r12!=null){
                if (id == r12.requestCode) {
                    r12.expressListener.onDownloadComplete(r12.filename);
                    r12 = null;
                }
            }

            if (r13!=null){
                if (id == r13.requestCode) {
                    r13.expressListener.onDownloadComplete(r13.filename);
                    r13 = null;
                }
            }

            if (r14!=null){
                if (id == r14.requestCode) {
                    r14.expressListener.onDownloadComplete(r14.filename);
                    r14 = null;
                }
            }

            if (r15!=null){
                if (id == r15.requestCode) {
                    r15.expressListener.onDownloadComplete(r15.filename);
                    r15 = null;
                }
            }

        }
    };

    /**
     * This void helps us to add ExpressDownloader to the list of max 15
     */
    protected static void include(ExpressDownloader request) {
        if (r1 == null) {
            r1 = request;
            return;
        }

        if (r2 == null) {
            r2 = request;
            return;
        }

        if (r3 == null) {
            r3 = request;
            return;
        }

        if (r4 == null) {
            r4 = request;
            return;
        }

        if (r5 == null) {
            r5 = request;
            return;
        }
        if (r6 == null) {
            r6 = request;
            return;
        }
        if (r7 == null) {
            r7 = request;
            return;
        }
        if (r8 == null) {
            r8 = request;
            return;
        }
        if (r9 == null) {
            r9 = request;
            return;
        }
        if (r10 == null) {
            r10 = request;
            return;
        }

        if (r11 == null) {
            r11 = request;
            return;
        }
        if (r12 == null) {
            r12 = request;
            return;
        }
        if (r13 == null) {
            r13 = request;
            return;
        }
        if (r14 == null) {
            r14 = request;
            return;
        }
        if (r15 == null) {
            r15 = request;
            return;
        }
        throw new RuntimeException("Max download limit (15) reached!");

    }

}
