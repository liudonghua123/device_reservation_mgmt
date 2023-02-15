-- 注意：该页面对应的前台目录为views/paleontology文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2023021504074950440', NULL, '预约', '/paleontology/reservationList', 'paleontology/ReservationList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2023-02-15 16:07:44', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021504074950441', '2023021504074950440', '添加预约', NULL, NULL, 0, NULL, NULL, 2, 'paleontology:erp_reservation:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-15 16:07:44', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021504074950442', '2023021504074950440', '编辑预约', NULL, NULL, 0, NULL, NULL, 2, 'paleontology:erp_reservation:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-15 16:07:44', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021504074950443', '2023021504074950440', '删除预约', NULL, NULL, 0, NULL, NULL, 2, 'paleontology:erp_reservation:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-15 16:07:44', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021504074950444', '2023021504074950440', '批量删除预约', NULL, NULL, 0, NULL, NULL, 2, 'paleontology:erp_reservation:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-15 16:07:44', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021504074950445', '2023021504074950440', '导出excel_预约', NULL, NULL, 0, NULL, NULL, 2, 'paleontology:erp_reservation:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-15 16:07:44', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021504074950446', '2023021504074950440', '导入excel_预约', NULL, NULL, 0, NULL, NULL, 2, 'paleontology:erp_reservation:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-15 16:07:44', NULL, NULL, 0, 0, '1', 0);