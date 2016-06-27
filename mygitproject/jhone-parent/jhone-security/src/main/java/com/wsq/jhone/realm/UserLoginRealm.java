package com.wsq.jhone.realm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wsq.jhone.base.exception.ValidCodeException;
import com.wsq.jhone.token.CustomUsernamePasswordToken;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserLoginRealm extends AuthorizingRealm{
	private static final Logger logger = LoggerFactory.getLogger(UserLoginRealm.class);
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		logger.info("进入判断");
		String username = (String) arg0.getPrimaryPrincipal(); //获取shiro的PrincipalCollection
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(); //实例化shiro的简单验证 
   //     authorizationInfo.setRoles(userDAO.getUserRoles(username));  //设置角色
  //      authorizationInfo.setStringPermissions(userDAO.findPermissions(username));  //设置权限
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("进入判断1");
		CustomUsernamePasswordToken login_token = (CustomUsernamePasswordToken) token;//验证标识
        //校验码判断逻辑  
        //取得用户输入的校验码  
		 String userInputValidCode = login_token.getValidCode();  
		//取得真实的正确校验码  
        String realRightValidCode = (String) SecurityUtils.getSubject().getSession().getAttribute("rand");  
        if (null == userInputValidCode || !userInputValidCode.equalsIgnoreCase(realRightValidCode)) {  
            logger.debug("验证码输入错误");  
            throw new ValidCodeException("验证码输入不正确");  
        }  
        //以上校验码验证通过以后,查数据库  
        String username = (String) token.getPrincipal();  
      //  SysUserEntity user = userDAO.findByUsername(username);  
     /*   if (user == null) {  
            throw new UnknownAccountException();//没找到帐号  
        }  
  
        if (Boolean.FALSE.equals(user.getValid())) {  
            throw new LockedAccountException(); //帐号锁定  
        }  */
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现  
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(  
        /*        user.getLoginName(), //用户名  
                user.getLoginPass(), //密码  
                getName()  //realm name  
*/        );  
        return authenticationInfo;  
	}
	 @Override  
	 //清楚缓存
	    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {  
	        super.clearCachedAuthorizationInfo(principals);  
	    } 
	 @Override  
	    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {  
	        super.clearCachedAuthenticationInfo(principals);  
	    } 
	 @Override  
	    public void clearCache(PrincipalCollection principals) {  
	        super.clearCache(principals);  
	    }  
	  
	    public void clearAllCachedAuthorizationInfo() {  
	        getAuthorizationCache().clear();  
	    }  
	  //清除带有认证的缓存
	    public void clearAllCachedAuthenticationInfo() {  
	        getAuthenticationCache().clear();  
	    }  
	  //清除所有的缓存
	    public void clearAllCache() {  
	        clearAllCachedAuthenticationInfo();  
	        clearAllCachedAuthorizationInfo();  
	    }  
}
