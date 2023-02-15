package org.jeecg.modules.demo.paleontology.service.impl;

import org.jeecg.modules.demo.paleontology.entity.Reservation;
import org.jeecg.modules.demo.paleontology.mapper.ReservationMapper;
import org.jeecg.modules.demo.paleontology.service.IReservationService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 预约
 * @Author: jeecg-boot
 * @Date:   2023-02-15
 * @Version: V1.0
 */
@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation> implements IReservationService {

}
