package com.elife.net;
/***
 * 请求action
 * @author zhangtengteng
 *
 */
public interface IRequestAction {
	
	/**
	 * 获取权限
	 */
	String APPMEMBERACTION_PERMISSIONS="/admin/api/index.php/user/getUserName";
	/***
	 * 获取验证码
	 */
	String APPMEMBERACTION_CODE="/admin/api/index.php/user/getVcode";
	/***
	 * 注册
	 */
	String APPMEMBERACTION_REGISTER="/admin/api/index.php/user/checkValidate";
	/**
	 * 登录
	 */
	String APPMEMBERACTION_LOGIN = "appMemberAction_login";
	
	
	/**
	 * 订单统计
	 */
	String APPMEMBERACTION_ORDERPAY = "appMemberAction_orderPay";
	
	/**
	 * 订单核验
	 */
	String APPMEMBERACTION_ORDERCHECK = "appMemberAction_orderCheck";
	
	
	
}
