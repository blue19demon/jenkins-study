package com.tgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgb.bean.User;
import com.tgb.disconf.prop.MysqlConfig;
import com.tgb.utils.DBMananger;

@Service
public class UserService {
	@Autowired
	private MysqlConfig mysqlConfig;

	public List<User> queryAll() {
		Connection conn;
		PreparedStatement ps = null;
		List<User> list = new ArrayList<User>();
		conn = DBMananger.getConnection(mysqlConfig);
		try {
			ps = conn.prepareStatement("select user_id,user_name,`password`,phone from `t_user`");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getString("password"), rs.getInt("user_id"), rs.getString("phone"), rs.getString("user_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBMananger.closeConnection(conn, ps);
		}
		return list;
	}
}
