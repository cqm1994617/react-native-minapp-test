package com.minapp;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXSDK extends ReactContextBaseJavaModule {

  private static ReactApplicationContext reactContext;
  private IWXAPI api;

  public WXSDK(ReactApplicationContext context) {
    super(reactContext);
    reactContext = context;

    String appId = "wxb2414e59f4b3e6c9"; // 填应用AppId
    api = WXAPIFactory.createWXAPI(getReactApplicationContext(), appId);
  
  }

  public void openWXSDK() {

    WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
    req.userName = "gh_bbab14219cd7"; // 填小程序原始id
    req.path = "/pages/index/index";                  ////拉起小程序页面的可带参路径，不填默认拉起小程序首页，对于小游戏，可以只传入 query 部分，来实现传参效果，如：传入 "?foo=bar"。
    req.miniprogramType = WXLaunchMiniProgram.Req.MINIPTOGRAM_TYPE_RELEASE;// 可选打开 开发版，体验版和正式版
    api.sendReq(req);

  }

  @Override
  public String getName() {
    return "WXSDK";
  }

}
