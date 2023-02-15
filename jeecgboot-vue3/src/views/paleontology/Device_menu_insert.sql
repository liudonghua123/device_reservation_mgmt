-- 注意：该页面对应的前台目录为views/paleontology文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2023021504065460530', NULL, '设备', '/paleontology/deviceList', 'paleontology/DeviceList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2023-02-15 16:06:53', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021504065470531', '2023021504065460530', '添加设备', NULL, NULL, 0, NULL, NULL, 2, 'paleontology:erp_device:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-15 16:06:53', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021504065470532', '2023021504065460530', '编辑设备', NULL, NULL, 0, NULL, NULL, 2, 'paleontology:erp_device:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-15 16:06:53', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021504065470533', '2023021504065460530', '删除设备', NULL, NULL, 0, NULL, NULL, 2, 'paleontology:erp_device:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-15 16:06:53', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021504065470534', '2023021504065460530', '批量删除设备', NULL, NULL, 0, NULL, NULL, 2, 'paleontology:erp_device:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-15 16:06:53', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021504065470535', '2023021504065460530', '导出excel_设备', NULL, NULL, 0, NULL, NULL, 2, 'paleontology:erp_device:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-15 16:06:53', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021504065470536', '2023021504065460530', '导入excel_设备', NULL, NULL, 0, NULL, NULL, 2, 'paleontology:erp_device:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-15 16:06:53', NULL, NULL, 0, 0, '1', 0);