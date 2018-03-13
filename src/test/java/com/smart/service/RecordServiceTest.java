package com.smart.service;

import com.smart.domain.Record;
import com.smart.test.dataset.util.XlsDataSetBeanFactory;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBean;

import java.util.List;
import java.util.Map;
import static org.testng.Assert.*;
public class RecordServiceTest extends BaseServiceTest {

    @SpringBean("recordService")
    RecordService recordService;

    @BeforeMethod
    public void init(){
        SessionFactory sf  = hibernateTemplate.getSessionFactory();
        Map<String, CollectionMetadata> roleMap = sf.getAllCollectionMetadata();
        for (String roleName : roleMap.keySet()) {
            sf.evictCollection(roleName);
        }
        Map<String, ClassMetadata> entityMap = sf.getAllClassMetadata();
        for (String entityName : entityMap.keySet()) {
            sf.evictEntity(entityName);
        }
        sf.evictQueries();
    }

    @Test
    @DataSet("XiaoChun.DataSet.xls")
    public void addRecord() throws Exception {
        Record record = XlsDataSetBeanFactory.createBean(ForumServiceTest.class,
                "XiaoChun.DataSet.xls", "t_record", Record.class);

        recordService.addRecord(record);
        Record recordDb = recordService.getRecordById(record.getRecordId());
        assertEquals(recordDb.getRecordText(), "enya");
    }

    @Test
    @DataSet("XiaoChun.DataSet.xls")
    // 准备验证数据
    public void removeRecord() {
        recordService.removeRecord(98);
        Record recordDb = recordService.getRecordById(98);
        assertNull(recordDb);
    }

    @Test
    @DataSet("XiaoChun.DataSet.xls")
    public void getRecordByUserIdTest(){
        List<Record> records = recordService.getRecordByUserId(2);
        assertEquals(2,records.size());
    }


}
