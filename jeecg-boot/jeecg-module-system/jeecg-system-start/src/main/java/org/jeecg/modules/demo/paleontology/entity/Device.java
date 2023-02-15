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
 * @Description: 设备
 * @Author: jeecg-boot
 * @Date:   2023-02-15
 * @Version: V1.0
 */
@Data
@TableName("erp_device")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="erp_device对象", description="设备")
public class Device implements Serializable {
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
	/**设备名称*/
	@Excel(name = "设备名称", width = 15)
    @ApiModelProperty(value = "设备名称")
    private java.lang.String name;
	/**设备编号*/
	@Excel(name = "设备编号", width = 15)
    @ApiModelProperty(value = "设备编号")
    private java.lang.String deviceId;
	/**设备介绍*/
	@Excel(name = "设备介绍", width = 15)
    @ApiModelProperty(value = "设备介绍")
    private java.lang.String introduction;
	/**设备操作指南*/
	@Excel(name = "设备操作指南", width = 15)
    @ApiModelProperty(value = "设备操作指南")
    private java.lang.String guide;
	/**设备注意事项*/
	@Excel(name = "设备注意事项", width = 15)
    @ApiModelProperty(value = "设备注意事项")
    private java.lang.String notes;
	/**设备类别*/
	@Excel(name = "设备类别", width = 15, dicCode = "device_category")
	@Dict(dicCode = "device_category")
    @ApiModelProperty(value = "设备类别")
    private java.lang.String category;
	/**负责人*/
	@Excel(name = "负责人", width = 15, dictTable = "sys_user", dicText = "realname", dicCode = "username")
	@Dict(dictTable = "sys_user", dicText = "realname", dicCode = "username")
    @ApiModelProperty(value = "负责人")
    private java.lang.String manager;
	/**实验室名称*/
	@Excel(name = "实验室名称", width = 15, dicCode = "lab_name")
	@Dict(dicCode = "lab_name")
    @ApiModelProperty(value = "实验室名称")
    private java.lang.String labName;
	/**门牌号*/
	@Excel(name = "门牌号", width = 15, dicCode = "lab_position")
	@Dict(dicCode = "lab_position")
    @ApiModelProperty(value = "门牌号")
    private java.lang.String position;
}
