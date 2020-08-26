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
public class PdmRealSend implements Serializable {

    private static final long serialVersionUID= 2532258048723782237L;

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
     * 监测单元ID
     */
    @TableField("unitId")
    private Integer unitId;

    /**
     * 监测单元名称
     */
    @TableField("unitName")
    private String unitName;

    /**
     * 数据时间
     */
    @TableField("dataTime")
    private Date dataTime;

    /**
     * 谱图时间标识
     */
    @TableField("filePos")
    private String filePos;

    /**
     * PD统计
     */
    @TableField("PDCount")
    private Integer pdCount;

    @TableField("maxAmp")
    private Float maxAmp;

    @TableField("faultNote")
    private String faultNote;

    /**
     * 状态
     */
    private Integer status;

    @TableField("avgAmp")
    private Float avgAmp;

    @TableField("maxPhase")
    private Float maxPhase;

    @TableField("libCode")
    private Integer libCode;

    @TableField("faultCode")
    private Integer faultCode;

    @TableField("faultName")
    private String faultName;

    @TableField("dangerVal")
    private Float dangerVal;

    @TableField("freqPoint")
    private Integer freqPoint;

    @TableField("PTOffset")
    private Float ptOffset;

    /**
     * 谱图数据
     */
    @TableField("RstData")
    private byte[] rstData;


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

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public String getFilePos() {
        return filePos;
    }

    public void setFilePos(String filePos) {
        this.filePos = filePos;
    }

    public Integer getPdCount() {
        return pdCount;
    }

    public void setPdCount(Integer pDCount) {
        this.pdCount = pDCount;
    }

    public Float getMaxAmp() {
        return maxAmp;
    }

    public void setMaxAmp(Float maxAmp) {
        this.maxAmp = maxAmp;
    }

    public String getFaultNote() {
        return faultNote;
    }

    public void setFaultNote(String faultNote) {
        this.faultNote = faultNote;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getAvgAmp() {
        return avgAmp;
    }

    public void setAvgAmp(Float avgAmp) {
        this.avgAmp = avgAmp;
    }

    public Float getMaxPhase() {
        return maxPhase;
    }

    public void setMaxPhase(Float maxPhase) {
        this.maxPhase = maxPhase;
    }

    public Integer getLibCode() {
        return libCode;
    }

    public void setLibCode(Integer libCode) {
        this.libCode = libCode;
    }

    public Integer getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(Integer faultCode) {
        this.faultCode = faultCode;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public Float getDangerVal() {
        return dangerVal;
    }

    public void setDangerVal(Float dangerVal) {
        this.dangerVal = dangerVal;
    }

    public Integer getFreqPoint() {
        return freqPoint;
    }

    public void setFreqPoint(Integer freqPoint) {
        this.freqPoint = freqPoint;
    }

    public Float getPtOffset() {
        return ptOffset;
    }

    public void setPtOffset(Float ptOffset) {
        this.ptOffset = ptOffset;
    }

    public byte[] getRstData() {
        return rstData;
    }

    public void setRstData(byte[] RstData) {
        this.rstData = RstData;
    }

    @Override
    public String toString() {
        return "PdmRealSend{" +
        "id=" + id +
        ", objId=" + objId +
        ", objName=" + objName +
        ", unitId=" + unitId +
        ", unitName=" + unitName +
        ", dataTime=" + dataTime +
        ", filePos=" + filePos +
        ", PDCount=" + pdCount +
        ", maxAmp=" + maxAmp +
        ", faultNote=" + faultNote +
        ", status=" + status +
        ", avgAmp=" + avgAmp +
        ", maxPhase=" + maxPhase +
        ", libCode=" + libCode +
        ", faultCode=" + faultCode +
        ", faultName=" + faultName +
        ", dangerVal=" + dangerVal +
        ", freqPoint=" + freqPoint +
        ", PTOffset=" + ptOffset +
        ", RstData=" + rstData +
        "}";
    }
}
