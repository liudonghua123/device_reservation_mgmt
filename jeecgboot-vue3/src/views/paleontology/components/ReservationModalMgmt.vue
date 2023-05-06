<template>
  <BasicModal v-bind="$attrs" @register="registerModal" destroyOnClose :title="title" :width="896" @ok="handleSubmit">
      <BasicForm @register="registerForm"/>
  </BasicModal>
</template>

<script lang="ts" setup>
    import {ref, computed, unref} from 'vue';
    import {BasicModal, useModalInner} from '/@/components/Modal';
    import {BasicForm, useForm} from '/@/components/Form/index';
    import {formSchema} from '../Reservation.data.mgmt';
    import {saveOrUpdate} from '../Reservation.api';
    import {extraReservationValidation} from '../utilities'
    import { notification, message } from 'ant-design-vue';
    // Emits声明
    const emit = defineEmits(['register','success','error']);
    const isUpdate = ref(true);
    //表单配置
    const [registerForm, {setProps,resetFields, setFieldsValue, validate}] = useForm({
        //labelWidth: 150,
        schemas: formSchema,
        showActionButtonGroup: false,
        baseColProps: {span: 12}
    });
    //表单赋值
    const [registerModal, {setModalProps, closeModal}] = useModalInner(async (data) => {
        //重置表单
        await resetFields();
        setModalProps({confirmLoading: false,showCancelBtn:!!data?.showFooter,showOkBtn:!!data?.showFooter});
        isUpdate.value = !!data?.isUpdate;
        if (unref(isUpdate)) {
            //表单赋值
            await setFieldsValue({
                ...data.record,
            });
        }
        // 隐藏底部时禁用整个表单
       setProps({ disabled: !data?.showFooter })
    });
    //设置标题
    const title = computed(() => (!unref(isUpdate) ? '新增' : '编辑'));
    //表单提交事件
    async function handleSubmit(v) {
        try {
            let values = await validate();
            const {code, message: text} = extraReservationValidation(values)
            console.info(`extraReservationValidation(values)`,{code, text})
            if (code !== 0) {
              // notification.error({text});
              message.error(text);
              return;
            }
            setModalProps({confirmLoading: true});
            //提交表单
            const result = await saveOrUpdate(values, isUpdate.value);
            console.info(`saveOrUpdate(values, isUpdate.value)`,{result});
            //关闭弹窗
            closeModal();
            //刷新列表
            emit('success');
        } catch (error) {
            console.info(`error`,{error})
            message.error(error.message);
            emit('error', error.message);
        } finally {
            setModalProps({confirmLoading: false});
        }
    }
</script>

<style lang="less" scoped>
	/** 时间和数字输入框样式 */
  :deep(.ant-input-number){
		width: 100%
	}

	:deep(.ant-calendar-picker){
		width: 100%
	}
</style>
