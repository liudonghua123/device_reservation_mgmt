package org.jeecg.modules.demo.paleontology.service;

import org.jeecg.modules.demo.paleontology.entity.Reservation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 预约
 * @Author: jeecg-boot
 * @Date:   2023-02-15
 * @Version: V1.0
 */
public interface IReservationService extends IService<Reservation> {

    boolean checkConflictByCurrentUser(Reservation reservation);

    boolean checkConflictByRelatedDevice(Reservation reservation);

}
