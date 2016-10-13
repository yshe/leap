package com.yabushan.test.util.common;

/**
 * 
 * <code>{@link ErrMsgType}</code>
 *
 * TODO : document me
 *
 * @author yabushan
 */
public enum  ErrMsgType {
	
	
	
	LOGGIN_SUCCESS(0,"登录成功"),
	LOGIN_FAIL(-1,"登录失败"),
	
	REGISTER_FAIL(-1,"注册失败"),
	REGISTER_SUCCESS(1,"注册成功"),
	
	ACCOUNT_NOTEXISTED(-4,"用户不存在"),
	ACCOUNT_EXISTED(-5,"用户已存在"),
	
	SEND_SUCCESS(2,"短信发送成功"),
	SEND_FAIL(-2,"短信发送失败"),
	    
	VALIDATION_CODE_ERROR(-3,"验证码错误"),
    VALIDATION_CODE_SUCCESS(3,"验证成功"),
   
   
    
    PASSWORD_FAIL(-6,"密码错误"),
    PASSWORD_SUCCESS(6,"密码正确"),
    
    FAIL(-1,"处理失败"),
    SUCCESS(0,"成功"),
   
    CODE_ALERDYSEND(-7,"短信已发送，请10分钟后重试"),
    
   
    REDIS_FAIL(-8,"redis系统繁忙,请稍后重试"),
    
    SHOP_REGISTER_SUCCESS(9,"商铺注册成功"),
    SHOP_REGISTER_FAIL(-9,"商铺注册失败"),
    
   SERCH_NEARSHOP_SUCCESS(10,"查询附近商铺查询成功"),
   SERCH_NEARSHOP_FAIL(-10,"查询附近商铺查询失败"),
    
    PUBLISH_COUPON_SUCCESS(11,"发布优惠券成功"),
    PUBLISH_COUPON_FAIL(-11,"发布优惠券失败"),
    
    GET_COUPONS_FROM_SHOP_SUCCESS(12,"获取商铺所有优惠券成功"),
    GET_COUPONS_FROM_SHOP_FAIL(-12,"获取商铺所有优惠券失败"),
    
    
    GET_ONE_COUPON_SUCCESS(14,"获取一张优惠券成功"),
    GET_ONE_COUPON_FAIL(-14,"获取一张优惠券失败"),
    
    OPEN_SHOP_SUCCESS(13,"店铺开门成功"),
    OPEN_SHOP_FAIL(-13,"店铺开门失败"),
    
    SHOP_LOGIN_SUCCESS(17,"商家登录成功"),
    SHOP_LOGIN_FAIL(-17,"商家登录失败"),
    
    CODE_INPUT_SUCCESS(15,"验证码输入正确"),
    CODE_INPUT_FAIL(-15,"验证码输入失败"),
    
    UPDATE_PASSWORD_SUCCESS(16,"修改密码成功"),
    UPDATE_PASSWORD_FAIL(-16,"修改密码失败"),
    
    
    
    GET_MYCOUPONS_LIST_SUCCESS(18,"获取我的优惠券列表成功"),
    GET_MYCOUPONS_LIST_FAIL(-18,"获取我的优惠券列表失败"),
    
    
    
    NOT_ANNY_COUPONS(19,"你还没有优惠券可以使用"),
    
    YOU_HAVA_THE_COUPONS(-19,"你已经领取过了该优惠券"),
    
    SHOP_NOT_EXIST(20,"商铺不存在"),
    
    
    NOT_COUPONS(21,"优惠券已被领取完"),
    
    
    NOT_ANNY_GOODS(-21,"没有商品"),
    
    GET_GOODS_SUCCESS(22,"获取商品列表成功"),
    
    NEAR_NOT_GOODS_ADVICE(-22,"附近没有商品推荐"),
    
    NEAR_GET_GOODS_SUCCESS(23,"获取附近推荐商品成功"),
    
    ADD_GOODS_SUCCESS(24,"添加商品成功"),
    ADD_GOODS_FAIL(-23,"添加商品失败"),
    
    
    FIND_GOODS_SUCCESS(25,"查找商品成功！"),
    FIND_GOODS_FAIL(-25,"查找商品失败"),
    
    
    GET_USER_INFO_SUCCESS(26,"获取用户个人信息成功"),
    GET_USER_INFO_FAIL(-26,"获取用户个人信息失败"),
    
    UPDATE_USER_INFO_SUCCESS(27,"修改个人信息成功"),
    UPDATE_USER_INFO_FAIL(-27,"修改个人信息失败"),
    
    
    
    GET_SHOP_INFO_SUCCESS(28,"查看商铺信息成功"),
    GET_SHOP_INFO_FAIL(-28,"查看商铺信息失败"),
    
    
    
    UPDATE_SHOP_INFO_SUCCESS(29,"修改商铺信息成功"),
    UPDATE_SHOP_INFO_FAIL(-29,"修改商铺信息失败"),
    
    COLLECTION_SHOP_SUCCESS(30,"收藏店铺成功"),
    COLLECTION_SHOP_FAIL(-30,"收藏店铺失败"),
    
    CANCEL_COLLECTION_SHOP_SUCCESS(31,"取消收藏店铺成功"),
    CANCEL_COLLECTION_SHOP_FAIL(-31,"取消收藏店铺失败"),
    
    GET_FAV_SHOP_SUCCESS(32,"获取收藏店铺成功"),
    GET_FAV_SHOP_FAIL(-32,"获取收藏店铺失败"),
    
    COLLECTION_GOODS_SUCCESS(33,"收藏商品成功"),
    COLLECTION_GOODS_FAIL(-33,"收藏商品失败"),
    
    CANCEL_COLLECTION_GOODS_SUCCESS(34,"取消收藏商品成功"),
    CANCEL_COLLECTION_GOODS_FAIL(-34,"取消收藏商品失败"),
    
    
    ANSWER_SUCCESS(35,"密保答案正确"),
    ANSWER_FAIL(-35,"密保答案错误"),
    
    
    GET_ALL_COLL_GOODS_SUCCESS(36,"获取收藏的所有商品成功"),
    GET_ALL_COLL_GOODS_FAIL(-36,"获取收藏的所有商品失败"),
    
    
    
    
    USE_EXIT_INSQL(37,"用户存在"),
    USER_ANSWER_NOT_SET(-37,"该用户没有设置密保"),
    
    
    APPLY_IN_CHEACK(38,"店铺申请在审核中"),
    
    
    GET_CLASS_SUCCESS(39,"获取大小类成功"),
    GET_CLASS_FAIL(-39,"获取大小类失败"),
    
    REPORT_SUCCESS(40,"举报成功"),
    REPORT_FAIL(-40,"举报失败"),
    
    
    ADD_POST_SUCCESS(41,"新增帖子成功"),
    ADD_POST_FAIL(-41,"新增帖子失败"),
    
    
    DELETE_POST_SUCCESS(42,"删除帖子成功"),
    DELETE_POST_FAIL(-42,"删除帖子失败"),
    
    SEARCH_NEAR_POST_SUCCESS(43,"查看附近的帖子成功"),
    SEARCH_NEAR_POST_FAIL(-43,"附近没有帖子"),
    
    
    ADD_TOO_POST_SUCCESS(44,"评论成功"),
    ADD_TOO_POST_FAIL(-44,"评论失败"),
    
    
    GET_ALL_DISCUSS_SUCCESS(45,"获取全部评论成功"),
    GET_ALL_DISCUSS_FAIL(-45,"获取全部评论失败"),
    
    DELETE_DISCUSS_SUCCESS(46,"删除评论成功"),
   DELETE_DISCUSS_FAIL(-46,"删除评论失败"),
   
   SHOP_GET_COUNPONS_SUCCESS(47,"商家查看发布的所有优惠券成功"),
   SHOP_GET_COUNPONS_FAIL(-47,"商家查看发布的优惠券失败"),
   
   UPDATE_DYNAMIC_SUCCESS(48,"修改动态成功"),
   UPDATE_DYNAMIC_FAIL(-48,"修改动态失败"),
   
   
   
   ADD_NEW_VIP_SUCCESS(49,"添加会员成功"),
   ADD_NEW_VIP_FAIL(-49,"添加会员失败"),
   
   
   GETVIPCARD_SUCCESS(50,"获取vipcard成功"),
   GETVIPCARD_FAIL(-50,"获取vipcard失败"),
   
   ADD_NEW_VIPCARD_LEAVER_SUCCESS(51,"增加会员卡等级成功"),
   ADD_NEW_VIPCARD_LEAVER_FAIL(-51,"增加会员卡等级失败"),
    
    
   GET_VIPCARD_SUCCESS(52,"商家获取会员卡等级卡成功"),
   NOT_ANY_VIPCARD_SET(-52,"商家还没有设置任何会员等级卡"),
   
   
   
   SHOP_ADD_LEVELRULE_SUCCESS(53,"商家添加积分规则成功"),
   SHOP_ADD_LEVELRULE_FAIL(-53,"商家添加积分规则失败"),
   
   
   SHOP_UPDATE_LEVELRULE_SUCCESS(54,"商家更新积分规则成功"),
   SHOP_UPDATE_LEVELRULE_FAIL(-54,"商家更新积分规则失败"),
   GET_LEVELRULE_SUCCESS(55,"获取积分规则成功"),
   GET_LEVELRULE_FAIL(-55,"获取积分规则失败"),
   
   
   DEL_LEVELRULE_SUCCESS(56,"删除积分规则成功"),
   DEL_LEVELRULE_FAIL(-56,"删除积分规则失败"),
   
   
   
   DEL_LEVEL_SUCCESS(57,"删除vip等级成功"),
   DEL_LEVEL_FAIL(-57,"删除vip等级失败"),
   
   
   ADD_LEVEL_FORVIP_SUCCESS(58,"添加用户积分成功！"),
   ADD_LEVEL_FORVIP_FAIL(-58,"添加用户积分失败"),
   
   
   GET_POST_CLASS_SUCCESS(59,"获取帖子分类成功"),
   GET_POST_CLASS_FAIL(-59,"获取帖子分类失败"),
   
   
   USE_LEVEL_SUCCESS(60,"用户使用积分成功"),
   USE_LEVEL_FAIL(-60,"用户使用积分失败"),
   
   
   LEVEL_ISNOT_ENOUGH(61,"积分不足"),
   
   DEL_GOODS_SUCCESS(62,"删除商品成功！"),
   DEL_GOODS_FAIL(-62,"删除商品失败"),
   
   
   UPDATE_WINDOWS_INFO_SUCCESS(62,"更新橱窗信息成功"),
   UPDATE_WINDOWS_INFO_FAIL(-62,"更新橱窗信息失败"),
   
   GET_MYWINOWS_SUCCESS(63,"获取我的橱窗成功"),
   GET_MYWINDOWS_FAIL(-63,"获取我的橱窗信息失败"),
   
   
   FIND_COUNPONS_BYCODE_SUCCESS(64,"根据代号查找优惠券成功"),
   FIND_COUNPONS_BYCODE_FAIL(-64,"根据代号查找优惠券失败"),
   
   
   
   DELETE_COUPONS_BYCODE_SUCCESS(65,"根据代号删除优惠券成功"),
   DELETE_COUPONS_BYCODE_FAIL(-65,"根据代号删除优惠券 失败"),
   
   MOVE_GOODS_FROM_WINDOWS_SUCCESS(66,"从橱窗中移除商品成功"),
   MOVE_GOODS_FROM_WINDOWS_FAIL(-66,"从橱窗中移除商品失败"),
   
   
   GET_MY_POST_SUCCESS(67,"获取我的帖子成功"),
   GET_MY_POST_FAIL(-67,"获取我的帖子失败"),
   
   GET_MY_DISCUSS_SUCCESS(68,"获取我的所有评论成功"),
   GET_MY_DISCUSS_FAIL(-68,"获取我的所有评论失败"),
   
   
   GET_REPLAY_MY_DISCUSS_SUCCESS(69,"获取所有评论我的评论成功"),
   GET_REPLAY_MY_DISCUSS_FAIL(-69,"获取所有评论我的评论失败"),
   
   
   
   GET_ONE_VIP_CARD_FAIL(-70,"获取vipcar失败"),
   GET_ONE_VIP_CARD_SUCCESS(70,"获取一张vipcard成功"),
   
   
   GET_ONE_POST_SUCCESS(70,"获取帖子成功"),
   GET_ONE_POST_FAIL(-70,"获取帖子失败"),
   
   DOWN_APP_FILE(71,"下载文件"),
   
   
   GET_RONG_TALK_SUCCESS(72,"融云聊天时，获取对方信息成功"),
   GET_RONG_TALK_FAIL(-72,"融云聊天时，获取对方信息失败"),
   
   GET_RANDOM_GOODS_SUCCESS(73,"随机获取附近商品成功"),
   GET_RANDOM_GOODS_FAIL(-73,"随机获取附近商品失败"),
   
   
   ACCESS_PHONE_ADDVIPORFIND_SUCCESS(74,"通过手机添加会员或者查找会员成功"),
   ACCESS_PHONE_ADDVIPORFIND_FAIL(-74,"通过手机号添加会员或者查找会员失败"),
   
   GET_A_ME_POST_SUCCESS(75,"获取a我的帖子成功"),
   GET_A_ME_POST_FAIL(-75,"获取a我的帖子失败"),
   
   
   SEND_TO_USER_SUCCESS(76,"商家推送会员邀请成功"),
   SEND_TO_USER_FAIL(-76,"商家推送会员邀请失败"),
   
   VIP_IS_EXITS(77,"vip已经存在"),
   
   SHOP_NOT_SET_VIPGRADER(78,"商店未设置vipgrader等级表"),
   
   
   GET_APP_VERSION_FAIL(-79,"获取APP版本失败"),
   GET_APP_VERSION_SUCCESS(79,"获取APP版本成功"),
   
   
   USER_COUPONS_SUCCESS(80,"使用优惠券成功！！！"),
   USER_COUPONS_FAIL(-80,"使用优惠券失败"),
   USER_GET_RONGTOKEN_FAIL(-81,"用户获取融云token失败"),
   USER_GET_RONGTOKEN_SUCCESS(81,"用户获取融云token成功"),
   
   SHOP_GET_RONGTOKEN_FAIL(-82,"商店获取融云token失败"),
   SHOP_GET_RONGTOKEN_SUCCESS(82,"商店获取融云token成功"),
   
   SHOP_APPLY_PUSH_SUCCESS(83,"商家申请推送成功！！"),
   SHOP_APPLY_PUSH_FAIL(-83,"商家申请推送失败"),
   
   
   
   SHOP_PUBLISH_ACTION_SUCCESS(84,"发布活动成功"),
   SHOP_PUBLISH_ACTION_FAIL(-84,"发布活动失败"),
   
   SHOP_UPDATE_ACTION_SUCCESS(85,"修改活动成功"),
   SHOP_UPDATE_ACTION_FAIL(-85,"修改活动失败"),
   
   
   SHOP_DEL_ACTION_SUCCESS(86,"删除活动成功！"),
   SHOP_DEL_ACTION_FAIL(-86,"删除活动失败"),
   
   SHOP_OVER_ACTION_SUCCESS(87,"活动结束成功"),
   SHOP_OVER_ACTION_FAIL(-87,"活动结束失败"),
   
   
   GET_NEAR_ACTION_SUCCESS(88,"获取附近活动成功"),
   GET_NEAR_ACTION_FAIL(-88,"获取附近活动失败"),
   
   
   
   
   USER_JOIN_ACTION_SUCCESS(89,"关注活动成功"),
   USER_JOIN_ACTION_FAIL(-89,"关注活动失败"),
   
   USER_CANCEL_ACTION_FAIL(-90,"用户取消关注活动失败"),
   USER_CANCEL_ACTION_SUCCESS(90,"用户取消关注活动成功"),
   
   USER_ADD_ACTION_TALK_SUCCESS(100,"用户发布活动评论成功"),
   USER_ADD_ACTION_TALK_FAIL(-100,"用户发布活动评论失败"),
   
   USER_DEL_ACTION_TALK_SUCCESS(101,"用户发布活动评论成功"),
   USER_DEL_ACTION_TALK_FAIL(-101,"用户发布活动评论失败"),
   
   USER_GET_ACTION_TALK_SUCCESS(102,"用户获取活动的评论成功"),
   USER_GET_ACTION_TALK_FAIL(-102,"用户获取活动的评论失败"),
   
   
   SHOP_GET_ACTION_SUCCESS(103,"商家获取活动成功"),
   SHOP_GET_ACTION_FAIL(-103,"商家获取活动失败"),
   
   
   GET_ONE_ACTION_SUCCESS(104,"获取一个活动成功"),
   GET_ONE_ACTION_FAIL(-104,"获取一个活动失败"),
   
   SHOP_PUSH_ACTION_SUCCESS(105,"商家推送一个活动成功"),
   SHOP_PUSH_ACTION_FAIL(-105,"商家推送一个活动失败"),
   
   
   USER_GET_JOIN_ACTION_SUCCESS(106,"获取关注的活动成功"),
   USER_GET_JOIN_ACTION_FAIL(-106,"获取关注的活动失败"),
   
   
   USERNAME_EXIT(107,"用户名或者商店名存在"),
   
   
   ADD_FBACK_SUCCESS(108,"添加反馈成功！"),
   ADD_FBACK_FAIL(-108,"添加反馈失败"),
   
   
   
   GET_NEWEST_ACTION_SUCCESS(109,"获取一个商店最新活动成功"),
   GET_NEWEST_ACTION_FAIL(-109,"获取一个商店最新活动失败"),
   
   
   ADD_NEW_ADVBAR_SUCCESS(110,"新增广告条成功"),
   ADD_NEW_ADVBAR_FAIL(-110,"新增广告条失败"),
   
   SHOP_UPDATE_ADVBAR_SUCCESS(111,"商家修改广告条成功！"),
   SHOP_UPDATE_ADVBAR_FAIL(-111,"商家修改广告条失败"),
   
   
   SHOP_DEL_ADVBAR_SUCCESS(112,"商家删除广告条成功！"),
   SHOP_DEL_ADVBAR_FAIL(-112,"商家删除广告条失败"),
   
   SHOP_GET_ADVBAR_SUCCESS(113,"商家获取我的广告条成功！"),
   SHOP_GET_ADVBAR_FAIL(-113,"商家获取我的广告条失败"),
   
   GET_ADVBAR_LIST_SUCCESS(114,"获取广告条列表成功"),
   GET_ADVBAR_LIST_FAIL(-114,"获取广告条列表失败"),
   
    AUTHORIZE_FAIL(20000,"授权失败"),
    
    INVALID_TOKEN(20002,"无效token"),
    ERROR_CLIENTID(20003,"Token不是由本终端生成"),
    INVALID_USERID(20004,"无效Userid"),
    INVALID_RETOKEN(20005,"无效RefreshToken"),
    INVALID_CLIENTID(20006,"无效clientId"),
    TOKEN_EXPIRED(20007,"Token过期"),
    ILLEGAL_DATA(30000,"非法参数"),
    ERROR_DATA(30001,"错误参数"),
    NO_AUTH(30002,"不能給自己授权"),  
    HAD_AUTH(30003,"不能重复授权"),
    EMPTY_ACCOUNT(30004,"账户不存在"),
    ILLEGAL_OPTION(30005,"非法操作"),
    ILLEGAL_ACCOUNT_PASSWORD(30005,"用户名或密码错误"),
    SYSTEM_ERROR(40000,"系统错误"),
    SYSTEM_BUSY(40001,"系统繁忙"),
    FAMILY_ACCOUNT(50001,"家人账户无需预约"),
    INVALID_ORDER(60001,"无效订单号");
	 Integer errcode;
	 String errmsg;

	    private ErrMsgType(Integer errcode, String errmsg) {
	        this.errcode = errcode;
	        this.errmsg = errmsg;
	    }

	    public String getErrmsg() {
	        return errmsg;
	    }

	    public Integer getErrcode() {
	        return errcode;
	    }
}
