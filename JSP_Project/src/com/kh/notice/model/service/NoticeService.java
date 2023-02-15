package com.kh.notice.model.service;

//JDBCTemplate 클래스의 모든 메소드들을 가져다 쓸 수 있음
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class NoticeService {
	
	public ArrayList<Notice> selectNoticeList(){
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		
		close(conn);//JDBCTemplate.close(conn);
		
		return list;
	}
}
