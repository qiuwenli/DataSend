package com.lgom.transport.model;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mr qiu
 * @since 2020-06-17
 */
public class MddGcGramSend implements Serializable {

    private static final long serialVersionUID= 7857885119854686215L;

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 设备ID
     */
    @TableField("objId")
    private Integer objId;

    /**
     * 设备名称
     */
    @TableField("objName")
    private String objName;

    /**
     * 谱图时间
     */
    @TableField("gramTime")
    private Date gramTime;

    /**
     * 谱图数据
     */
    @TableField("gramData")
    private byte[] gramData;

    /**
     * 谱图类型
     */
    @TableField("gramType")
    private Integer gramType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public Date getGramTime() {
        return gramTime;
    }

    public void setGramTime(Date gramTime) {
        this.gramTime = gramTime;
    }

    public byte[] getGramData() {
        return gramData;
    }

    public void setGramData(byte[] gramData) {
        this.gramData = gramData;
    }

    public Integer getGramType() {
        return gramType;
    }

    public void setGramType(Integer gramType) {
        this.gramType = gramType;
    }

    @Override
    public String toString() {
        return "MddGcGramSend{" +
        "id=" + id +
        ", objId=" + objId +
        ", objName=" + objName +
        ", gramTime=" + gramTime +
        ", gramData=" + gramData +
        ", gramType=" + gramType +
        "}";
    }
}
