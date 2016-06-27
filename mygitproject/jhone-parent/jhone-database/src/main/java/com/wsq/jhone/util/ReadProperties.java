package com.wsq.jhone.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import javax.swing.Icon;

public class ReadProperties {
	  private static final Properties properties = new Properties();
	  public static String getString(String name)
	  {
	    String value = properties.getProperty(name);
	    if ((value == null) || ("".equals(value))) {
	      return null;
	    }
	    return value;
	  }

	  public static String getString(String name, String defvalue)
	  {
	    String value = properties.getProperty(name);
	    if ((value == null) || ("".equals(value))) {
	      return defvalue;
	    }
	    return value;
	  }
	  public static Icon getIcon(String name)
	  {
	    String value = getString(name);
	    if (value != null) {
	      return new LazyImageIcon(getResource(value));
	    }
	    return null;
	  }

	  public static Icon getResourceIcon(String name)
	  {
	    return new LazyImageIcon(getResource(name));
	  }

	  public static URL getResource(String name)
	  {
	    return ReadProperties.class.getResource(name);
	  }

	  static
	  {
	    try
	    {
	      InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybuild.properties");
	      properties.load(new BufferedReader(new InputStreamReader(is, "utf-8")));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
}
