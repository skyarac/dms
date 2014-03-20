package com.jgsu.dms.dao;


import org.springframework.stereotype.Repository;

import com.jgsu.dms.model.Attachment;

@Repository("attachmentDao")
public class AttachmentDao extends BaseDao<Attachment> implements
		IAttachmentDao {


}
