# ExpressDownloader
The simplest library to handle downloads via system DownloadManager
### Features or ExpressDownloader library
* ExpressDownloader can be used to download any type of files.
* This file downloader library uses DownloadManager class.
* Supports http response.
* We can easily enqueue a file.
* ExpressDownloader gives callbacks for onDownloadQueued, onComplete, onDownloadFailed.
* We can open files after downloading.
### Implementing the library
Add this in settings.gradle
```gradle
repositories {
   ...
   maven { url 'https://jitpack.io' }
}
```
Add the dependency in build.gradle (module)
```gradle
dependencies {
   implementation 'com.github.MAKENIQAL:ExpressDownloader:Latest version'
}
```

## Using ExpressDownloader Library in your Android application
Add all required permissions
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```
Then initialize it with Context :
```java
Express.init(this)
```
Or,
```java
Express.init(getApplicationContext())
```
Downloading a file
```java
new ExpressDownloader()
                .prepare(userAgent,contentDisposition,mimeType)
                .startDownload(url, new ExpressListener() {
                    @Override
                    public void onDownloadQueued() {
                        
                    }

                    @Override
                    public void onDownloadComplete(String filename) {

                    }

                    @Override
                    public void onDownloadFailed(String errorMessage) {

                    }
                });
```                
Or,
```java
ExpressDownloader downloader = new ExpressDownloader();
        downloader.prepare(userAgent, contentDisposition,mimeType);
        
        ExpressListener expressListener = new ExpressListener() {
            @Override
            public void onDownloadQueued() {
                
            }

            @Override
            public void onDownloadComplete(String filename) {

            }

            @Override
            public void onDownloadFailed(String errorMessage) {

            }
        };
        
        downloader.startDownload(url,expressListener);ExpressDownloader downloader = new ExpressDownloader();
        downloader.prepare(userAgent, contentDisposition,mimeType);
        
        ExpressListener expressListener = new ExpressListener() {
            @Override
            public void onDownloadQueued() {
                
            }

            @Override
            public void onDownloadComplete(String filename) {

            }

            @Override
            public void onDownloadFailed(String errorMessage) {

            }
        };
        
        downloader.startDownload(url,expressListener);
```        
