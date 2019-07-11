package com.tgb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tgb.disconf.prop.MysqlConfig;


/**
 * 根据配置文件，管理连接对象
 * 
 * @author 紫马
 *
 */
public class DBMananger {

	
	public static Connection getConnection(MysqlConfig mysqlConfig) {
		try {
			Class.forName(mysqlConfig.getDriver());
			return DriverManager.getConnection(mysqlConfig.getUrl(), mysqlConfig.getUsername(), mysqlConfig.getPassword());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConnection(Connection conn, PreparedStatement ps) {
		try {
			if (ps != null) {
				if (conn != null) {
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}