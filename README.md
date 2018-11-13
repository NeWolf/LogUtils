# LogUtils
This  is Lib for Android Log！

How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```
	dependencies {
	        implementation 'com.github.NeWolf:LogUtils:2.0.0'
	}
	```

Step 3. Set Application
```
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.INSTANCE.init(this);
    }
```
Step 4. Use
```
 NLogUtls.INSTANCE.e("This log is from NLogUtils");
```