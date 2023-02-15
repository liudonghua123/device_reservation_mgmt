package org.jeecg.modules.demo.paleontology.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.paleontology.entity.Reservation;
import org.jeecg.modules.demo.paleontology.service.IReservationService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.aspect.annotation.PermissionData;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 预约
 * @Author: jeecg-boot
 * @Date:   2023-02-15
 * @Version: V1.0
 */
@Api(tags="预约")
@RestController
@RequestMapping("/paleontology/reservation")
@Slf4j
public class ReservationController extends JeecgController<Reservation, IReservationService> {
	@Autowired
	private IReservationService reservationService;
	
	/**
	 * 分页列表查询
	 *
	 * @param reservation
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "预约-分页列表查询")
	@ApiOperation(value="预约-分页列表查询", notes="预约-分页列表查询")
	@GetMapping(value = "/list")
	@PermissionData(pageComponent="paleontology/ReservationList")
	public Result<IPage<Reservation>> queryPageList(Reservation reservation,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Reservation> queryWrapper = QueryGenerator.initQueryWrapper(reservation, req.getParameterMap());
		Page<Reservation> page = new Page<Reservation>(pageNo, pageSize);
		IPage<Reservation> pageList = reservationService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param reservation
	 * @return
	 */
	@AutoLog(value = "预约-添加")
	@ApiOperation(value="预约-添加", notes="预约-添加")
	//@RequiresPermissions("paleontology:erp_reservation:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody Reservation reservation) {
		reservationService.save(reservation);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param reservation
	 * @return
	 */
	@AutoLog(value = "预约-编辑")
	@ApiOperation(value="预约-编辑", notes="预约-编辑")
	//@RequiresPermissions("paleontology:erp_reservation:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody Reservation reservation) {
		reservationService.updateById(reservation);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "预约-通过id删除")
	@ApiOperation(value="预约-通过id删除", notes="预约-通过id删除")
	//@RequiresPermissions("paleontology:erp_reservation:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		reservationService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "预约-批量删除")
	@ApiOperation(value="预约-批量删除", notes="预约-批量删除")
	//@RequiresPermissions("paleontology:erp_reservation:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.reservationService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "预约-通过id查询")
	@ApiOperation(value="预约-通过id查询", notes="预约-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Reservation> queryById(@RequestParam(name="id",required=true) String id) {
		Reservation reservation = reservationService.getById(id);
		if(reservation==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(reservation);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param reservation
    */
    //@RequiresPermissions("paleontology:erp_reservation:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Reservation reservation) {
        return super.exportXls(request, reservation, Reservation.class, "预约");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("paleontology:erp_reservation:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Reservation.class);
    }

}
