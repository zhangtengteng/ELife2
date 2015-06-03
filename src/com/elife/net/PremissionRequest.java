package com.elife.net;

import java.util.ArrayList;
import java.util.List;

import android.os.Handler;
import android.os.Message;

import com.elife.model.RequestParamsModel;
import com.elife.model.ResponseResultModel;
import com.google.gson.Gson;
/**
 * 获取权限
 *
 */
public class PremissionRequest extends JSONRequest implements IRequestAction {
	private Gson gson= new Gson();
	private Handler handler;
	private String ucode;
	private String uid;
	public PremissionRequest(Handler handler) {
		super(handler);
		this.handler = handler;
	}

	public void setParams(String ucode, String uid) {
		this.ucode = ucode;
		this.uid = uid;
	}

	@Override
	public String getAction() {
		return APPMEMBERACTION_PERMISSIONS;
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
		model1.setKey("ucode");
		model1.setValue(ucode);
		list.add(model1);

		RequestParamsModel model2 = new RequestParamsModel();
		model2.setKey("uid");
		model2.setValue(uid);
		list.add(model2);
		return list;
	}

}
