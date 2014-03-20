package com.jgsu.dms.dao;

import com.jgsu.dms.model.Message;
import com.jgsu.dms.model.UserMessage;

public interface IMessageDao extends IBaseDao<Message>{
	/**
	 * 检查某个用户是否已经读过该msg
	 * @param userId 要检查的用户id
	 * @param msgId 私人信件id
	 * @return
	 */
	public boolean checkIsRead(int userId,int msgId);
	/**
	 * 根据用户id和私人信件id加载UserMessage对象
	 * @param userId
	 * @param msgId
	 * @return
	 */
	public UserMessage loadUserMessage(int userId,int msgId);
}
