package com.mov.mac.glko.manager;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

public class BaseApplication extends Application{
	/*全局context,原理是因为Application类是应用最先运行的，所以在 我们的代码调用时，该值已经被赋值过了。*/
	private static BaseApplication mInstance;
	/*主线程ID*/
	private static int mMainThreadId = -1;
	/*主线程*/
	private static Thread mMainThread;
	/*主线程Handler*/
	private static Handler mMainThreadHandler;
	/*主线程Looper*/
	private static Looper mMainLooper;
	
	@Override
	public void onCreate(){
		mMainThreadId =android.os.Process.myTid();
		mMainThread = Thread.currentThread();
		mMainThreadHandler =new Handler();
		mMainLooper =getMainLooper();
		mInstance = this;
	}
	
	public static BaseApplication getApplication(){
		return mInstance;
	}
	/*获取主线程ID*/
	public static int getMainThreadId(){
		return mMainThreadId;
	}
	/*获取主线程*/
	public static Thread getMainThread(){
		return mMainThread;
	}
	/*获取主线程的Handler*/
	public static Handler getMainThreadHandler(){
		return mMainThreadHandler;
	}
	/*获取主线程的looper*/
	public static Looper getMainThreadLooper(){
		return mMainLooper;
	}
}
