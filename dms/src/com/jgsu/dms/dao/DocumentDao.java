package com.jgsu.dms.dao;


import org.springframework.stereotype.Repository;

import com.jgsu.dms.model.Document;

@Repository("documentDao")
public class DocumentDao extends BaseDao<Document> implements IDocumentDao {


}
