package org.jeecg.modules.demo.paleontology.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.demo.paleontology.entity.Reservation;
import org.jeecg.modules.demo.paleontology.mapper.ReservationMapper;
import org.jeecg.modules.demo.paleontology.service.IReservationService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 预约
 * @Author: jeecg-boot
 * @Date: 2023-02-15
 * @Version: V1.0
 */
@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation> implements IReservationService {

    @Override
    public boolean checkConflictByCurrentUser(Reservation reservation) {
        String currentUserId = ((LoginUser) SecurityUtils.getSubject().getPrincipal()).getId();
        // 查询当前用户这段时间内是否有预约, 查询条件: 存在预约的开始时间或结束时间在当前预约的时间范围内，并且预约的审批状态不是已完成 5、已关闭 6
        QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .between("usageStartDatetime", reservation.getUsageStartDatetime(), reservation.getUsageEndDatetime())
                .or()
                .between("usageEndDatetime", reservation.getUsageStartDatetime(), reservation.getUsageEndDatetime())
                .notIn("approvalStatus", "5", "6")
                .eq("createBy", currentUserId);

        List<Reservation> results = this.getBaseMapper().selectList(queryWrapper);
        return results.size() > 0;
    }

    @Override
    public boolean checkConflictByRelatedDevice(Reservation reservation) {
            // 查询当前预约的设备是否在当前预约的时间段内可用, 查询条件: 存在预约的开始时间或结束时间在当前预约的时间范围内，并且预约的设备是当前预约的设备，并且预约的审批状态不是已完成 5、已关闭 6
            QueryWrapper<Reservation> queryWrapper = new QueryWrapper<>();
            queryWrapper
                    .between("usageStartDatetime", reservation.getUsageStartDatetime(), reservation.getUsageEndDatetime())
                    .or()
                    .between("usageEndDatetime", reservation.getUsageStartDatetime(), reservation.getUsageEndDatetime())
                    .notIn("approvalStatus", "5", "6")
                    .eq("deviceId", reservation.getDeviceId());
    
            List<Reservation> results = this.getBaseMapper().selectList(queryWrapper);
            return results.size() > 0;
    }

}
