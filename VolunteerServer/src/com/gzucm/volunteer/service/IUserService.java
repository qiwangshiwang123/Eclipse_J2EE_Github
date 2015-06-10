package com.gzucm.volunteer.service;

import com.gzucm.volunteer.domain.User;
/**
 * 用户表
 * @author 万允山
 * @version 1.0
 *
 */
public interface IUserService {
	public final static String SERVICE_NAME = "com.gzucm.volunteer.service.impl.UserServiceImpl";

	/**  
	* @Name: save
	* @Description: 保存对象
	* @Author: 万允山（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-2-1 （创建日期）
	* @Parameters:User
	* @Return: null
	*/
	public void save(User user);

	/**  
	* @Name: update
	* @Description: 修改用户信息
	* @Author: 万允山（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-2-2（创建日期）
	* @Parameters:user
	* @Return:
	*/
	public void update(User user);
	
	/**  
	* @Name: findUserByTelephone
	* @Description: 根据手机号查询用户
	* @Author: 万允山（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-2-1 （创建日期）
	* @Parameters:telephone
	* @Return: User
	*/
	public User findUserByTelephone(String telephone);

	/**  
	* @Name: findUserByAccount
	* @Description: 根据账号查询用户
	* @Author: 万允山（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-2-1 （创建日期）
	* @Parameters:account
	* @Return: User
	*/
	public User findUserByAccount(String account);

	/**  
	* @Name: findUserById
	* @Description: 根据id查询用户
	* @Author: 万允山（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-2-6 （创建日期）
	* @Parameters:userId
	* @Return: User
	*/
	public User findUserById(String userId);

}
