package com.smart.dao;

import com.smart.domain.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordDao extends BaseDao<Record>{

    private static final String GET_RECORD_BY_ID = "from Record r where recordId=?";

    private static final String GET_RECORDS_BY_USERID = "from Record where userId = ? order by createTime desc";

    private static final String GET_PAGED_RECORDS = "from Record order by createTime desc";

    public Record getRecordById(int recordId){
        List<Record> records = (List<Record>)getHibernateTemplate().find(GET_RECORD_BY_ID,recordId);
        if (records.size() == 0) {
            return null;
        }else{
            return records.get(0);
        }
    }

    public List<Record> getRecordByUserId(int userId){
        return (List<Record>)getHibernateTemplate().find(GET_RECORDS_BY_USERID,userId);
    }

    public List<Record> getRecordByTime(){
        return null;
    }


    public Page getPagedRecords(int pageNo, int pageSize) {
        return pagedQuery(GET_PAGED_RECORDS,pageNo,pageSize);
    }



}
