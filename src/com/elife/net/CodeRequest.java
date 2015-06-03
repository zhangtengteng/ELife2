package com.elife.net;

import java.util.ArrayList;
import java.util.List;

import android.os.Handler;
import android.os.Message;

import com.elife.model.RequestParamsModel;

/**
 * 获取验证码
 * 
 */
public class CodeRequest extends JSONRequest implements IRequestAction {
	private Handler handler;
	private String phone;
	private String ucode;
	private String uid;

	public CodeRequest(Handler handler) {
		super(handler);
		this.handler = handler;
	}

	public void setParams(String phone, String ucode, String uid) {
		this.uid = uid;
		this.ucode = ucode;
		this.phone = phone;
	}

	@Override
	public String getAction() {
		return APPMEMBERACTION_CODE;
	}

	@Override
	protected void onHttpSuccess(String str) {
		Message msg = new Message();
		msg.what = CommonData.HTTP_HANDLE_SUCCESS;
		msg.obj = str;
		handler.sendMessage(msg);

	}

	@Override
	protected void onHttpFailure(int errorCode, String why) {
		Message msg = new Message();
		msg.what = CommonData.HTTP_HANDLE_FAILE;
		msg.obj = why;
		handler.sendMessage(msg);
	}

	@Override
	protected List<RequestParamsModel> getParamList() {
		List<RequestParamsModel> list = new ArrayList<RequestParamsModel>();

		RequestParamsModel model1 = new RequestParamsModel();
		model1.setKey("phone");
		model1.setValue(phone);
		list.add(model1);

		RequestParamsModel model2 = new RequestParamsModel();
		model2.setKey("uid");
		model2.setValue(uid);
		list.add(model2);

		RequestParamsModel model3 = new RequestParamsModel();
		model3.setKey("ucode");
		model3.setValue(ucode);
		list.add(model3);
		return list;
	}
}
