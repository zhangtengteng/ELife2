package com.elife.net;

public class CommonData {
	public static String server_ip = "";

	public static String SERVER_ADDRESS = "http://192.168.4.252:8081/";
	public static String IMAGE_ADDRESS = ".scar.com.cn/upload/fuwu/";

	public static final int HTTP_HANDLE_SUCCESS = 1;
	public static final int HTTP_HANDLE_FAILE = 0;

	/**
	 * 一页数量
	 */
	public static final int pageSize = 3;
	//已支付
	public static final String PAY = "0";
	//已消费
	public static final String COUSUME = "1";
	//全部
	public static final String TIME_ALL = "0";
	//一个月
	public static final String TIME_MONTH = "1";
	//一个星期
	public static final String TIME_WEEk = "2";
	
	
	   
    /**
     * HOME
     */
  
    public static final int TAB_HOME_INDEX = 0;
    
    /**
     * 我的订单
     */
    public static final int TAB_ORDER_INDEX = 1;
    
    /**
     * 购物车
     */
    public static final int TAB_SHOP_INDEX = 2;
    /**
     *帮助
     */
    public static final int TAB_HELP_INDEX = 3;
    /**
     * 我的
     */
    public static final int TAB_ME_INDEX = 4;
	
	
	/**
	 * 排序方式
	 */
	public static final int sort_type_1 = 0;// 0：默认；1：最新上架；2：价格最低；3：价格最高
	public static final int sort_type_2 = 1;
	public static final int sort_type_3 = 2;
	public static final int sort_type_4 = 3;
}
