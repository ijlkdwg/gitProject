package com.wsq.jhone.dbconnect.adapter;

import java.io.Serializable;

public class ControlAdapter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private String sql;
	  private Object[] args;
	  private String dataSource;

	  public String getSql()
	  {
	    return this.sql;
	  }
	  public void setSql(String sql) {
	    this.sql = sql;
	  }
	  public Object[] getArgs() {
	    return this.args;
	  }
	  public void setArgs(Object[] args) {
	    this.args = args;
	  }
	  public String getDataSource() {
	    return this.dataSource;
	  }
	  public void setDataSource(String dataSource) {
	    this.dataSource = dataSource;
	  }
}
