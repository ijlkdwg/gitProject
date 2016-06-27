package com.wsq.jhone.util;

import com.wsq.jhone.error.ErrCodeCache;

public class ErrCodeUtil {
	 public static String getErrDesc(String errCode, Object[] args){
		 if ((errCode == null) || ("".equals(errCode))) {
		      return "";
		    }
		 String errDesc = ErrCodeCache.getErrDesc(errCode);
		 if (errDesc == null) {
		      ErrCodeCache.load(errCode);
		      errDesc = ErrCodeCache.getErrDesc(errCode);
		    }
		 if (errDesc == null) {
		      return "";
		    }
		 if ((errDesc.indexOf("}") > -1) && (errDesc.indexOf("}") > -1)) {
		      return StringUtil.formatPositionString(errDesc, args);
		    }
		    return StringUtil.formatPatternString(errDesc, args);
		  }
	 public static String getErrSolution(String errCode) {
		 if ((errCode == null) || ("".equals(errCode))) {
		      return "";
		    }
		 String errSolution = ErrCodeCache.getErrSolution(errCode);
		    if (errSolution == null) {
		      ErrCodeCache.load(errCode);
		      errSolution = ErrCodeCache.getErrSolution(errCode);
		    }
		    if (errSolution == null) {
		      return "";
		    }
		    return errSolution;
	 }
}
