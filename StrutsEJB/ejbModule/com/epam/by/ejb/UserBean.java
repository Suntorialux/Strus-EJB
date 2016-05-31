/**
 * 
 */
package com.epam.by.ejb;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author Andrei Yahorau
 *
 */
@SuppressWarnings("serial")
public class UserBean implements EntityBean {

	EntityContext entityContext;
	int userId;
	String login;
	String password;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	public UserPK ejbCreate(String login, String password) {
		this.login = login;
		this.password = password;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String sql = "Insert into users (login, password) values (?,?)";
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new UserPK();
	}

	public void ejbPostCreate(String login, String password) {

	}

	public UserPK ejbFindByPrimaryKey(UserPK userPk) {
		return new UserPK();
	}

	public boolean ejbHomeIsUserExist(String login, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean result = false;
		try {
			String sql = "Select login, password FROM users WHERE login like binary ? && password like binary ?";
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public void ejbActivate() throws EJBException, RemoteException {

	}

	@Override
	public void ejbLoad() throws EJBException, RemoteException {

	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {

	}

	@Override
	public void ejbRemove() throws RemoveException, EJBException, RemoteException {

	}

	@Override
	public void ejbStore() throws EJBException, RemoteException {

	}

	@Override
	public void setEntityContext(EntityContext context) throws EJBException, RemoteException {
		this.entityContext = context;
	}

	@Override
	public void unsetEntityContext() throws EJBException, RemoteException {
		this.entityContext = null;
	}

	public Connection getConnection() {
		DataSource ds = null;
		Connection con = null;
		InitialContext initialContext;
		try {
			initialContext = new InitialContext();
			ds = (DataSource) initialContext.lookup("java:/MySqlDS");
			con = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
