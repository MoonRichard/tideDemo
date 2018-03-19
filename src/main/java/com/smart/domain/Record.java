package com.smart.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
//更新缓存时会加锁，其他事务会去数据库查询
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "t_record")
////指定PO映射继承关系
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "post_type", discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("1")
public class Record extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private int recordId;

    @Column(name = "record_text")
    private String recordText;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "event_Location")
    private String eventLocation;

     @Column(name = "event_time")
    private java.sql.Date eventTime;

    @Column(name = "create_Time")
    private Timestamp createTime;
    @Column(name = "favor_num")
    private int favorNum;

    public Record() {
        super();
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getRecordText() {
        return recordText;
    }

    public void setRecordText(String recordText) {
        this.recordText = recordText;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }


    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getFavorNum() {
        return favorNum;
    }

    public void setFavorNum(int favorNum) {
        this.favorNum = favorNum;
    }

    public java.sql.Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(java.sql.Date eventTime) {
        this.eventTime = eventTime;
    }
}
