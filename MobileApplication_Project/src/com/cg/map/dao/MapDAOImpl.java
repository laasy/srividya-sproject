package com.cg.map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.StampedLock;

import org.apache.log4j.Logger;

import com.cg.map.exception.MPException;
import com.cg.map.model.MobileDetails;
import com.cg.map.model.Mobiles;
import com.cg.map.utility.JdbcUtility;

public class MapDAOImpl implements MapDAO {
	Connection connection = null;
	PreparedStatement statement = null;

	ResultSet resultSet = null;
	private int quantity;
	private int id;

	static Logger logger = Logger.getLogger(MapDAOImpl.class);

	public int addPurchaseDetails(MobileDetails details) throws MPException {

		logger.info("in add purchasedetails method");

		connection = JdbcUtility.getConnection();
		logger.info("connection statement created");
     
		
		int id ,quantity,result=0;
		int generatedId = 0;
		boolean idflag = false;
		boolean quantityFlag = false;
		try {
			statement = connection
					.prepareStatement(QueryMapper.selectAll);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				id = resultSet.getInt("mobileid");
				quantity = resultSet.getInt("quantity");
				
				if(id == details.getMobile_id()){
					
				idflag = true;
				if(quantity>0)
				{quantityFlag = true;
				statement=connection.prepareStatement(QueryMapper.updateBasedOnQuantity);
				statement.setInt(1, id);
			 result=statement.executeUpdate();
				
			statement = connection
					.prepareStatement(QueryMapper.insertPurchaseDetails);
			logger.info("statement object created");

			statement.setString(1, details.getCustomer_Name());
			statement.setString(2, details.getMailId());
			statement.setLong(3, details.getPhone_Number());
			statement.setInt(4, details.getMobile_id());
			System.out.println("setter");

			generatedId = statement.executeUpdate();
			System.out.println("execution");
			logger.info("execute update called");
				}if(idflag == false)
				{
					System.out.println("id not present");
				}if(quantityFlag == false)
				{
					System.out.println("mobiles are not present");
				}
			
			logger.info("generated id is:" + generatedId);
			}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				statement.close();
				logger.info("statement closed");
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MPException("problem occured while closing statement");
			}
			try {
				connection.close();
				logger.info("connection closed");
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MPException(
						"problem occured while closing connection");
			}

		}
		return generatedId;

	}


	@Override
	public int deleteBasedOnId(Mobiles mobiles2) throws MPException {

		ResultSet resultSet = null;
		int result = 0;
		connection = JdbcUtility.getConnection();

		try {
			statement = connection
					.prepareStatement(QueryMapper.deleteBasedOnId);
		
			statement.setInt(1, id);
		
			result = statement.executeUpdate();
			//System.out.println("lalala");
			/*statement.setString(1, mobiles2.getName());
			statement.setDouble(2, mobiles2.getPrice());
			statement.setInt(3, mobiles2.getQuantity());
			*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*try {
			resultSet.close();
		} catch (SQLException e) {
			throw new MPException("statement not closed");
		}*/

		try {
			statement.close();
		} catch (SQLException e) {
			throw new MPException("statement not closed");
		}
		try {
			connection.close();
		} catch (SQLException e) {
			throw new MPException("connection not closed");
		}
		return result;

	}
}