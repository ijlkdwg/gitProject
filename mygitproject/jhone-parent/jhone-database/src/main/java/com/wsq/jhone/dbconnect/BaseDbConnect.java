package com.wsq.jhone.dbconnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import com.wsq.jhone.base.exception.WsqTransSingleException;
import com.wsq.jhone.dbconnect.adapter.ControlAdapter;
import com.wsq.jhone.util.ReadProperties;

public class BaseDbConnect {
	private static final Logger logger = LoggerFactory.getLogger(BaseDbConnect.class);
	private JdbcTemplate jdbcTemplate;
	private String dbName;
	private int maxRows = 2147483647;
	private static final ThreadLocal<Vector<ControlAdapter>> cacheSqls = new ThreadLocal();

	@Autowired
	public void setDataSource(@Qualifier("d_dataid") DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		Connection con = null;
		try {
			con = dataSource.getConnection();
			this.dbName = con.getMetaData().getDatabaseProductName();
			this.dbName = this.dbName.toLowerCase();
		} catch (SQLException e) { 
			this.dbName = ReadProperties.getString("dbType");
			logger.info("未获取到数据库类型，默认从配置文件中取");
			//Thread.currentThread().getContextClassLoader().getResourceAsStream("db.propertiest");
			//throw new WsqTransSingleException("获取数据库类型异常【"+this.getClass().getName()+"】"+e.getMessage());
		}finally {
		      try {
		          con.close();
		        } catch (SQLException e) {
		          logger.error("数据库连接关闭错误");
		          e.printStackTrace();
		        }
		      }
		      String maxRows = ReadProperties.getString("maxRows");
		      if (maxRows != null)
		        this.maxRows = Integer.parseInt(maxRows);

	}
	 public Connection getConnection(){
		 try
		    {
		      return this.jdbcTemplate.getDataSource().getConnection();
		    } catch (SQLException e) {
		      logger.error("获取数据库连接错误");
		      e.printStackTrace();
		    }return null;
	 }

}
