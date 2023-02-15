package org.jeecg.modules.demo.paleontology.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 预约
 * @Author: jeecg-boot
 * @Date:   2023-02-15
 * @Version: V1.0
 */
@Data
@TableName("erp_reservation")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="erp_reservation对象", description="预约")
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**设备*/
	@Excel(name = "设备", width = 15, dictTable = "erp_device", dicText = "name", dicCode = "id")
	@Dict(dictTable = "erp_device", dicText = "name", dicCode = "id")
    @ApiModelProperty(value = "设备")
    private java.lang.String deviceId;
	/**使用开始时间*/
	@Excel(name = "使用开始时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "使用开始时间")
    private java.util.Date usageStartDatetime;
	/**使用结束时间*/
	@Excel(name = "使用结束时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "使用结束时间")
    private java.util.Date usageEndDatetime;
	/**实验项目*/
	@Excel(name = "实验项目", width = 15)
    @ApiModelProperty(value = "实验项目")
    private java.lang.String experimentName;
	/**实验内容*/
	@Excel(name = "实验内容", width = 15)
    @ApiModelProperty(value = "实验内容")
    private java.lang.String experimentContent;
	/**测试样品描述*/
	@Excel(name = "测试样品描述", width = 15)
    @ApiModelProperty(value = "测试样品描述")
    private java.lang.String sampleDescription;
	/**测样数量*/
	@Excel(name = "测样数量", width = 15)
    @ApiModelProperty(value = "测样数量")
    private java.lang.String sampleAmount;
	/**使用方向*/
	@Excel(name = "使用方向", width = 15, dicCode = "reservation_usage")
	@Dict(dicCode = "reservation_usage")
    @ApiModelProperty(value = "使用方向")
    private java.lang.String usageDirection;
	/**审批状态*/
	@Excel(name = "审批状态", width = 15, dicCode = "approval_status")
	@Dict(dicCode = "approval_status")
    @ApiModelProperty(value = "审批状态")
    private java.lang.String approvalStatus;
	/**审批备注*/
	@Excel(name = "审批备注", width = 15)
    @ApiModelProperty(value = "审批备注")
    private java.lang.String approvalMessage;
	/**使用后设备照片*/
	@Excel(name = "使用后设备照片", width = 15)
    @ApiModelProperty(value = "使用后设备照片")
    private java.lang.String photosAfterUsage;
}
