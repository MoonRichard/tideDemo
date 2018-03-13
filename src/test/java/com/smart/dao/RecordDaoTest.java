package com.smart.dao;

import com.smart.domain.Board;
import com.smart.domain.Post;
import com.smart.domain.Record;
import com.smart.test.dataset.util.XlsDataSetBeanFactory;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringApplicationContext({"xiaochun-dao.xml"})
public class RecordDaoTest extends UnitilsTestNG {

    @SpringBean("recordDao")
    private RecordDao recordDao;

    @Test
    @DataSet("XiaoChun.Record.xls")//准备数据
    public void findRecordByRecordIdTest() {
        Record record=recordDao.getRecordById(10);
        assertNull("不存在ID=1的Record!", record);
        record=recordDao.get(2);
        assertNotNull("Jan用户存在！", record);
        assertEquals(record.getUserId(),1);
        assertEquals(record.getEventLocation(),"北京");
    }

    @Test
    @DataSet("XiaoChun.Record.xls")//准备数据
    public void findRecordByUserIdTest() {
       List<Record> list = recordDao.getRecordByUserId(3);
       assertEquals("user=3的用户没有record",0,list.size());
       list = recordDao.getRecordByUserId(1);
       assertEquals("userid=1的用户record存在",3,list.size());

    }

    @Test
    @DataSet("XiaoChun.Record.xls")//准备数据
    public void pagedRecordIdTest() {
        Page page = recordDao.getPagedRecords(1,7);
        assertNotNull("获取成功", page);
        assertEquals(page.getResult(),new ArrayList(){});

    }





}
