/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : pms_db

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-24 18:24:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sub_system
-- ----------------------------
DROP TABLE IF EXISTS `sub_system`;
CREATE TABLE `sub_system` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '子系统名称',
  `project_name` varchar(30) DEFAULT NULL COMMENT '项目名',
  `code` varchar(30) NOT NULL COMMENT '系统编码',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '最新更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`,`code`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='子系统';

-- ----------------------------
-- Records of sub_system
-- ----------------------------
INSERT INTO `sub_system` VALUES ('1', 'pms', '权限系统', '866848898700831111', '权限系统', 'admin', '2017-11-08 15:22:30', 'admin', '2017-11-08 15:22:32');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `code` varchar(30) DEFAULT NULL COMMENT '编码',
  `long_code` varchar(150) DEFAULT NULL COMMENT '长编码',
  `status` int(1) DEFAULT NULL COMMENT '状态(1:启用,2:禁用)',
  `sub_system_code` varchar(30) DEFAULT NULL COMMENT '关联子系统',
  `parent_code` varchar(30) DEFAULT NULL COMMENT '父编码',
  `url` varchar(60) DEFAULT NULL COMMENT '访问路径',
  `is_menu` int(1) DEFAULT '1' COMMENT '1:菜单,2:权限项',
  `orders` int(11) DEFAULT '0' COMMENT '排序字段',
  `level` int(2) DEFAULT NULL COMMENT '级别',
  `icon_code` varchar(30) DEFAULT NULL COMMENT '菜单样式',
  `permission` varchar(50) DEFAULT NULL COMMENT '权限标识',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '最新更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='系统资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '权限管理', '866595798555656192', '866595798555656192', '1', '866848898700831111', null, 'resource/list_menu', '1', '4', '1', 'fa fa-key', null, 'resource', 'admin@btte.net', '2017-05-22 18:05:14', 'admin@btte.net', '2017-06-12 14:27:25');
INSERT INTO `sys_resource` VALUES ('2', '资源管理', '866595883125407744', '866595798555656192,866595883125407744', '1', '866848898700831111', '866595798555656192', 'pms/resource/list', '1', '1', '2', 'icon', 'sys:resource:list', null, 'admin@btte.net', '2017-05-22 18:05:34', 'admin@btte.net', '2017-06-02 13:57:37');
INSERT INTO `sys_resource` VALUES ('3', '用户管理', '866848827737407488', '866595798555656192,866848827737407488', '1', '866848898700831111', '866595798555656192', 'user/list', '1', '2', '2', 'icon', null, 'ffffff', 'admin@btte.net', '2017-05-23 10:50:40', 'admin@btte.net', '2017-05-23 10:50:40');
INSERT INTO `sys_resource` VALUES ('4', '角色管理', '866848898700836864', '866595798555656192,866848898700836864', '1', '866848898700831111', '866595798555656192', 'role/list', '1', '3', '2', 'icon', 'sys:role:list', 'ffasdfasdfgghh', 'admin@btte.net', '2017-05-23 10:50:57', 'admin@btte.net', '2017-06-02 15:12:30');
INSERT INTO `sys_resource` VALUES ('5', '角色权限设置', '870516832400859136', '866595798555656192,866848898700836864,870516832400859136', '1', '866848898700831111', '866848898700836864', 'role/resourceSetting', '2', '1', '3', null, 'sys:role:resourceSetting', null, 'admin@btte.net', '2017-06-02 13:46:01', 'admin@btte.net', '2017-06-02 13:46:01');
INSERT INTO `sys_resource` VALUES ('6', '角色添加&修改', '870518310993682432', '866595798555656192,866848898700836864,870518310993682432', '1', '866848898700831111', '866848898700836864', 'role/resource/edit', '2', '2', '3', null, 'sys:role:edit', null, 'admin@btte.net', '2017-06-02 13:51:54', 'admin@btte.net', '2017-06-02 13:51:53');
INSERT INTO `sys_resource` VALUES ('7', '添加修改菜单', '870518762313375744', '866595798555656192,866595883125407744,870518762313375744', '1', '866848898700831111', '866595883125407744', 'resource/addEdit', '2', '2', '3', null, 'sys:menu:edit', null, 'admin@btte.net', '2017-06-02 13:53:41', 'admin@btte.net', '2017-06-02 13:53:41');
INSERT INTO `sys_resource` VALUES ('8', '添加修改权限项', '870518983730683904', '866595798555656192,866595883125407744,870518983730683904', '1', '866848898700831111', '866595883125407744', 'permission/addEdit', '2', '2', '3', null, 'sys:permission:edit', null, 'admin@btte.net', '2017-06-02 13:54:34', 'admin@btte.net', '2017-06-02 13:54:34');
INSERT INTO `sys_resource` VALUES ('9', '删除菜单权限', '870519327332261888', '866595798555656192,866595883125407744,870519327332261888', '1', '866848898700831111', '866595883125407744', 'pms/resource/delete', '2', '3', '3', null, 'sys:menu:delete', null, 'admin@btte.net', '2017-06-02 13:55:56', 'admin@btte.net', '2017-06-02 13:55:56');
INSERT INTO `sys_resource` VALUES ('10', '权限删除权限', '870519474401337344', '866595798555656192,866595883125407744,870519474401337344', '1', '866848898700831111', '866595883125407744', 'permission/delete', '2', '4', '3', null, 'sys:permission:delete', null, 'admin@btte.net', '2017-06-02 13:56:31', 'admin@btte.net', '2017-06-02 13:56:31');
INSERT INTO `sys_resource` VALUES ('11', '角色启用禁用', '870521335120420864', '866595798555656192,866848898700836864,870521335120420864', '1', '866848898700831111', '866848898700836864', 'role/enable', '2', '4', '3', null, 'sys:role:enable', null, 'admin@btte.net', '2017-06-02 14:03:55', 'admin@btte.net', '2017-06-23 15:50:41');
INSERT INTO `sys_resource` VALUES ('12', '添加账户权限', '425022833241030656', '866595798555656192,866848827737407488,425022833241030656', '1', '866848898700831111', '866848827737407488', 'user/partner/add', '2', '1', '3', null, 'sys:user:partner:add', null, 'admin@btte.net', '2017-09-12 11:43:55', 'admin@btte.net', '2017-09-12 11:43:55');
INSERT INTO `sys_resource` VALUES ('13', '账户修改权限', '425028504292360192', '866595798555656192,866848827737407488,425028504292360192', '1', '866848898700831111', '866848827737407488', 'user/partner/edit', '2', '2', '3', null, 'sys:user:partner:edit', null, 'admin@btte.net', '2017-09-12 12:06:27', 'admin@btte.net', '2017-09-12 12:06:27');
INSERT INTO `sys_resource` VALUES ('14', '账户删除权限', '425028916437254144', '866595798555656192,866848827737407488,425028916437254144', '1', '866848898700831111', '866848827737407488', 'user/partner/delete', '2', '3', '3', null, 'sys:user:partner:delete', null, 'admin@btte.net', '2017-09-12 12:08:05', 'admin@btte.net', '2017-09-12 12:08:05');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(30) DEFAULT NULL COMMENT '编码',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `status` int(1) DEFAULT NULL COMMENT '状态(1:启用,2:禁用)',
  `role_type` varchar(30) DEFAULT NULL COMMENT '角色类型',
  `remark` varchar(120) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '最新更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='系统角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '445738124174856192', '超级管理员', '1', 'SUPER_ADMIN', '超管', 'admin', '2017-11-08 15:39:40', 'admin', '2017-11-08 15:39:47');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_code` varchar(30) DEFAULT NULL COMMENT '角色编码',
  `resource_code` varchar(30) DEFAULT NULL COMMENT '资源编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统角色资源关联表';

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `default_role` varchar(30) DEFAULT NULL COMMENT '默认角色',
  `status` int(1) DEFAULT NULL COMMENT '状态(1:启用,2:禁用)',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '最新更新人',
  `last_update_date` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'd93a5def7511da3d0f2d171d9c344e91', '管理员', '445738124174856192', '1', 'admin@btte.net', 'admin', '2017-11-08 14:36:13', 'admin', '2017-11-08 14:36:21');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户账号',
  `role_code` varchar(30) DEFAULT NULL COMMENT '角色编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', 'admin', '445738124174856192');
