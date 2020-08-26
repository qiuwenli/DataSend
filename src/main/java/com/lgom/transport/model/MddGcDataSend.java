package com.lgom.transport.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mr qiu
 * @since 2020-06-15
 */
public class MddGcDataSend implements Serializable {

    private static final long serialVersionUID= -7336136158552741394L;

    /**
     * 唯一标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 设备ID
     */
    @TableField("objId")
    private Integer objId;

    /**
     * 数据时间
     */
    @TableField("dataTime")
    private Date dataTime;

    /**
     * 监测因子标识
     */
    @TableField("kindId")
    private Integer kindId;

    /**
     * 监测因子名称
     */
    @TableField("kindName")
    private String kindName;

    /**
     * 设备名称
     */
    @TableField("objName")
    private String objName;

    /**
     * 值
     */
    @TableField("dataValue")
    private Float dataValue;


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

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public Float getDataValue() {
        return dataValue;
    }

    public void setDataValue(Float dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public String toString() {
        return "MddGcDataSend{" +
        "id=" + id +
        ", objId=" + objId +
        ", dataTime=" + dataTime +
        ", kindId=" + kindId +
        ", kindName=" + kindName +
        ", objName=" + objName +
        ", dataValue=" + dataValue +
        "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MddGcDataSend that = (MddGcDataSend) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(objId, that.objId) &&
                Objects.equals(dataTime, that.dataTime) &&
                Objects.equals(kindId, that.kindId) &&
                Objects.equals(kindName, that.kindName) &&
                Objects.equals(objName, that.objName) &&
                Objects.equals(dataValue, that.dataValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objId, dataTime, kindId, kindName, objName, dataValue);
    }
}
