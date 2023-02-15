import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '设备名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '设备编号',
    align:"center",
    dataIndex: 'deviceId'
   },
   {
    title: '设备类别',
    align:"center",
    dataIndex: 'category_dictText'
   },
   {
    title: '负责人',
    align:"center",
    dataIndex: 'manager_dictText'
   },
   {
    title: '实验室名称',
    align:"center",
    dataIndex: 'labName_dictText'
   },
   {
    title: '门牌号',
    align:"center",
    dataIndex: 'position_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "设备名称",
      field: 'name',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "设备编号",
      field: 'deviceId',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "设备介绍",
      field: 'introduction',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "设备操作指南",
      field: 'guide',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "设备注意事项",
      field: 'notes',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "设备类别",
      field: 'category',
      component: 'JDictSelectTag',
      componentProps:{
          dictCode:"device_category"
      },
      colProps: {span: 6},
 	},
	{
      label: "负责人",
      field: 'manager',
      component: 'JSelectUserByDept',
      colProps: {span: 6},
 	},
	{
      label: "实验室名称",
      field: 'labName',
      component: 'JDictSelectTag',
      componentProps:{
          dictCode:"lab_name"
      },
      colProps: {span: 6},
 	},
	{
      label: "门牌号",
      field: 'position',
      component: 'JDictSelectTag',
      componentProps:{
          dictCode:"lab_position"
      },
      colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '设备名称',
    field: 'name',
    component: 'Input',
  },
  {
    label: '设备编号',
    field: 'deviceId',
    component: 'Input',
  },
  {
    label: '设备介绍',
    field: 'introduction',
    component: 'JEditor',
  },
  {
    label: '设备操作指南',
    field: 'guide',
    component: 'JEditor',
  },
  {
    label: '设备注意事项',
    field: 'notes',
    component: 'JEditor',
  },
  {
    label: '设备类别',
    field: 'category',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"device_category"
     },
  },
  {
    label: '负责人',
    field: 'manager',
    component: 'JSelectUserByDept',
    componentProps:{
        labelKey:'realname',
     },
  },
  {
    label: '实验室名称',
    field: 'labName',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"lab_name"
     },
  },
  {
    label: '门牌号',
    field: 'position',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"lab_position"
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