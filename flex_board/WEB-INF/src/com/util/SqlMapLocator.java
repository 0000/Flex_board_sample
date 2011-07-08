package com.util;
import java.io.IOException;
import java.io.Reader;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapLocator {
	public static SqlMapClient getMapper(){
		SqlMapClient sqlMapper;
	    try {
	    	Reader reader = Resources.getResourceAsReader(
	    		  "sqlmapclient/sqlmap-config.xml");
	    	sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
	    	reader.close(); 
	    } catch (IOException e) {
	    	// Fail fast.
	    	throw new RuntimeException(
	    		  "Something bad happened while building the SqlMapClient instance." + 
	    		  e, e);
	    }
	    return sqlMapper;
	}
}