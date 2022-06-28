package com.makeniqal.downloader.express;

import android.net.Uri;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Do not copy this code. Just share this library with credit
 * You can use this in your app without credit.
 * Created by MAKENIQAL
 * 06/02/2022
 * Thank you!
 */

public class ExpressUtils {

    /**
     * Content dispositions have various patterns
     * We found three different Patterns
     * We have to get FILE_NAME and MimeType from ContentDisposition with Regular expression
     */
    private static final Pattern PATTERN1 =
            Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN2 =
            Pattern.compile("attachment;\\s*filename\\*=UTF-8''(\"?)([^\"]*)\\1\\s*$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN3 =
            Pattern.compile("attachment;filename=\"(\"?)([^\"]*)\\1\\s*\";filename\\*\\=(\"?)([^\"]*)\\1\\s*$", Pattern.CASE_INSENSITIVE);

    /**
     * No instance
     */
    private ExpressUtils() { }

    /**
     * This method helps us to find the FILE_NAME from ContentDisposition.
     * It can extract URL to get FILE_NAME if ContentDisposition is empty
     */
    public static String guessFileName(String url, String disposition, String mimeType) {
        String filename = null;
        if (disposition != null) {
            filename = getFilenameFromDispo(disposition);
        }

        if (filename == null || TextUtils.isEmpty(filename)) {
            String decodedUrl = Uri.decode(url);
            if (decodedUrl != null) {
                int queryIndex = decodedUrl.indexOf('?');
                if (queryIndex > 0) {
                    decodedUrl = decodedUrl.substring(0, queryIndex);
                }
                if (!decodedUrl.endsWith("/")) {
                    int index = decodedUrl.lastIndexOf('/') + 1;
                    if (index > 0) {
                        filename = decodedUrl.substring(index);
                    }
                }
            }
        }
        if (filename == null) {
            filename = "unknownByMAKENIQAL";
        }
        int dotIndex = filename.indexOf('.' + 1);
        if (dotIndex == 0) {
            String fn = filename;
            String extension = null;
            extension = ExpressMap.get(mimeType);

            filename = fn + "." + extension;
        }

        return filename;
    }

    public static String getFilenameFromDispo(String dispo) {
        Matcher matcher = PATTERN1.matcher(dispo);
        if (matcher.find()) {
            return matcher.group(2);
        } else {
            matcher = PATTERN2.matcher(dispo);
            if (matcher.find()) {
                return matcher.group(2);
            } else {
                matcher = PATTERN3.matcher(dispo);
                if (matcher.find()) {
                    return matcher.group(2);
                }
            }
        }
        return null;
    }
}
