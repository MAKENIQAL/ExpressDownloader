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
