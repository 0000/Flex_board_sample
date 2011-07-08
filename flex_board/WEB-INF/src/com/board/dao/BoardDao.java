package com.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.board.model.*;
import com.util.SqlMapLocator;
import com.util.XmlParser;

public class BoardDao {
	private static BoardDao singleton;

	private BoardDao() {
	}

	public static BoardDao getInstance() {
		if (singleton == null)
			singleton = new BoardDao();
		return singleton;
	}
	public void insert(Object obj) throws SQLException {
		SqlMapLocator.getMapper().insert("BoardInsert", (BoardVo)obj);
	}
		
	public String list(Object obj) throws SQLException {			
		 List list = SqlMapLocator.getMapper().queryForList("BoardList", obj);
		 return XmlParser.toXml(list);
	}
	public int getMaxSeq() throws SQLException {		
		 return ((Integer)SqlMapLocator.getMapper().queryForObject("BoardMaxSeq")).intValue();
	}
	
	public void updateStep(Object obj) throws SQLException {
		SqlMapLocator.getMapper().update("BoardStepUpdate",obj);
	}
	public void updateHit(Object obj)throws SQLException{
		SqlMapLocator.getMapper().update("BoardHitUpdate",obj);
	}
	public void update(Object obj)throws SQLException{
		SqlMapLocator.getMapper().update("BoardUpdate",obj);
	}
	public void delete(Object obj)throws SQLException{
		SqlMapLocator.getMapper().delete("BoardDelete",obj);
	}
	public int getRowCount(Object obj) throws SQLException {		
		 return ((Integer)SqlMapLocator.getMapper().queryForObject("BoardCnt", obj)).intValue();
	}
	
}
