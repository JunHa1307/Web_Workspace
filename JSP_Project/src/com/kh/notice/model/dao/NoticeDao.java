package com.kh.notice.model.dao;
import static com.kh.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.kh.notice.model.vo.Notice;

public class NoticeDao {
	
	private Properties prop = new Properties();
	
	public NoticeDao() {
		String fileName = NoticeDao.class.getResource("/sql/notice/notice-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Notice> selectNoticeList(Connection conn){
		
		// SELECT문 => ResultSet(여러 행)
		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement pstmt =null;
		
		ResultSet rset= null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			// rset.next()함수를 통해 다음 행이 있는지 검사
			
			while(rset.next()) {
				Notice n = new Notice(
								rset.getInt("NOTICE_NO"),
								rset.getString("NOTICE_TITLE"),
								rset.getString("USER_ID"),
								rset.getInt("COUNT"),
								rset.getDate("CREATE_DATE")
								);
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
		
		
	}
}
