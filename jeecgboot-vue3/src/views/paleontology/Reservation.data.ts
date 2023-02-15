import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '设备',
    align:"center",
    dataIndex: 'deviceId_dictText'
   },
   {
    title: '使用开始时间',
    align:"center",
    dataIndex: 'usageStartDatetime'
   },
   {
    title: '使用结束时间',
    align:"center",
    dataIndex: 'usageEndDatetime'
   },
   {
    title: '实验项目',
    align:"center",
    dataIndex: 'experimentName'
   },
   {
    title: '测试样品描述',
    align:"center",
    dataIndex: 'sampleDescription'
   },
   {
    title: '测样数量',
    align:"center",
    dataIndex: 'sampleAmount'
   },
   {
    title: '使用方向',
    align:"center",
    dataIndex: 'usageDirection_dictText'
   },
   {
    title: '审批状态',
    align:"center",
    dataIndex: 'approvalStatus_dictText'
   },
   {
    title: '审批备注',
    align:"center",
    dataIndex: 'approvalMessage'
   },
   {
    title: '使用后设备照片',
    align:"center",
    dataIndex: 'photosAfterUsage',
    customRender:render.renderImage,
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "设备",
      field: 'deviceId',
      component: 'JSearchSelect',
      componentProps:{
         dict:"erp_device,name,id"
      },
      colProps: {span: 6},
 	},
	{
      label: "使用开始时间",
      field: 'usageStartDatetime',
      component: 'DatePicker',
      componentProps: {
         showTime:true,
         valueFormat: 'YYYY-MM-DD HH:mm:ss'
       },
      colProps: {span: 6},
 	},
	{
      label: "使用结束时间",
      field: 'usageEndDatetime',
      component: 'DatePicker',
      componentProps: {
         showTime:true,
         valueFormat: 'YYYY-MM-DD HH:mm:ss'
       },
      colProps: {span: 6},
 	},
	{
      label: "实验项目",
      field: 'experimentName',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "实验内容",
      field: 'experimentContent',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "测试样品描述",
      field: 'sampleDescription',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "测样数量",
      field: 'sampleAmount',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "使用方向",
      field: 'usageDirection',
      component: 'JDictSelectTag',
      componentProps:{
          dictCode:"reservation_usage"
      },
      colProps: {span: 6},
 	},
	{
      label: "审批状态",
      field: 'approvalStatus',
      component: 'JDictSelectTag',
      componentProps:{
          dictCode:"approval_status"
      },
      colProps: {span: 6},
 	},
	{
      label: "审批备注",
      field: 'approvalMessage',
      component: 'Input',
      colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '设备',
    field: 'deviceId',
    component: 'JSearchSelect',
    componentProps:{
       dict:"erp_device,name,id"
    },
  },
  {
    label: '使用开始时间',
    field: 'usageStartDatetime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '使用结束时间',
    field: 'usageEndDatetime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '实验项目',
    field: 'experimentName',
    component: 'Input',
  },
  {
    label: '实验内容',
    field: 'experimentContent',
    component: 'JEditor',
  },
  {
    label: '测试样品描述',
    field: 'sampleDescription',
    component: 'Input',
  },
  {
    label: '测样数量',
    field: 'sampleAmount',
    component: 'Input',
  },
  {
    label: '使用方向',
    field: 'usageDirection',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"reservation_usage"
     },
  },
  {
    label: '审批状态',
    field: 'approvalStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"approval_status"
     },
  },
  {
    label: '审批备注',
    field: 'approvalMessage',
    component: 'Input',
  },
  {
    label: '使用后设备照片',
    field: 'photosAfterUsage',
     component: 'JImageUpload',
     componentProps:{
      },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];



/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}