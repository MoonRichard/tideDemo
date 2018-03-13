package com.smart.service;

import com.smart.dao.Page;
import com.smart.dao.RecordDao;
import com.smart.domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    private RecordDao recordDao;

    @Autowired
    public void setRecordDao(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    /**载入所有记录**/
    public List<Record> getAllRecords(){
        return recordDao.loadAll();
    }
    /**根据记录id载入记录**/
    public Record getRecordById(int id){
        return recordDao.get(id);
    }
    /**根据用户id载入记录**/
    public List<Record> getRecordByUserId(int userId){
        return (List<Record>)recordDao.getRecordByUserId(userId);
    }
    //预留
    public List<Record> getRecordByTime(){
        return (List<Record>)recordDao.getRecordByTime();
    }
    /**新增记录**/
    public void addRecord(Record record){
        recordDao.save(record);
    }
    /**删除记录**/
    public void removeRecord(int recordId){
        recordDao.remove(recordDao.get(recordId));
    }

    /**
     * 分页获取记录
     * @param pageNo 页号
     * @param pageSize 单页记录数
     * **/
    public Page getPagedRecord(int pageNo, int pageSize){
        return recordDao.getPagedRecords(pageNo,pageSize);
    }




}
