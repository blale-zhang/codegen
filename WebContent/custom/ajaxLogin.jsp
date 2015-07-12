<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/context.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>${title}</title>
<link rel="stylesheet" href="${ctx}/custom/newlogin.css" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/component/LigerUI/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css"></link>
<%@ include file="/common/custom.jsp"%>
</head>
<body style="background-color:#ffffff;">
<div class="main">
 
  <div class="big">
    <div class="left">
      <div class="tbg" style="margin-top:5px;">
                    <img src="${ctx}/custom/images/login_07.gif" width="371" height="7" alt="" /></div>
      <div class="mbg">
        <div class="login">
          <div class="top"> <span class="left"> <img src="${ctx}/custom/images/login_15.gif" width="152"
                                    height="22" alt="免费模板用户登录" /></span> <span class="right"> <a href="http://www.mianfeimoban.com" target="_blank">手机账号</a> | <a href="http://www.mianfeimoban.com" target="_blank">邮箱账号</a></span> </div>
          <div class="form">
           <div class="hiddendiv">
             <div style="display: none;" id="errortips"> 请输入您的用户名</div>
           </div>
             <div class="user"> <span class="text">用户名：</span>
               <input name="userName" type="text" id="userName" value="" class="input" tabindex="1" />
             </div>
             <div class="user"> <span class="text">密 码：</span>
               <input name="password" type="password" id="password" class="input"
                                       tabindex="1" />
             </div>
             <div class="user"> <span class="text">验证码：</span>
               <input type="text" class="input1" id="code" tabindex="1" name="str_checkcode" />
               <input type="hidden" name="needvcode" value="1" />
               <span class="img">
               <img src="${ctx}/custom/images/CheckImage.gif"/>
               </span><span class="fonth"><a href="javascript:void(0);" onclick="ReFreshVCode();return false;"> 看不清？</a></span> </div>
             <div class="user1">
               <input type="checkbox" name="rememberme" checked="checked" id="rememberme" class="check" />
               <span class="font12">记住我的用户名</span> </div>
             <div class="user2">
               <input id="btnSubmit" tabindex="1" type="button" name="submit" value="登录" class="submit" />
               <span class="fonth"><a href="#">忘记密码？</a></span> </div>
          </div>
        </div>
      <!--   <div class="bg1">
          <div class="icon01"> <a href="#" title="点击下载，保存到桌面即可">设为桌面图标</a></div>
          <div class="icon02"> <a href="#">保存至收藏夹</a></div>
          <div class="icon03"> <a href="#">设为首页</a></div>
        </div> -->
        
<!--         <div class="bg2">
          <div class="login-w"> 您还没有注册账户？</div>
          <div class="floatl "> <a href="#" > <img src="images/login_08.gif" alt="注册" width="105" height="30" align="absmiddle" /></a></div>
        </div> -->
      </div>
      <div class="fbg"> </div>
    </div>
    
  
   </div>
   </div>
   <script src="${ctx}/custom/js/login.js" type="text/javascript"></script>
   <script type="text/javascript">
		// 	seajs.use([ '../custom/js/user-list' ]);//这句会把js引入
		seajs.use([ 'login' ]);
   </script>
</body>
</html>
