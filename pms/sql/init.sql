SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS sub_system;
DROP TABLE IF EXISTS sys_resource;
DROP TABLE IF EXISTS sys_role;
DROP TABLE IF EXISTS sys_role_resource;
DROP TABLE IF EXISTS sys_user;

/* Create Tables */

-- 子系统
CREATE TABLE sub_system
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
	name varchar(50) COMMENT '子系统名称',
	project_name varchar(30) COMMENT '项目名',
	code varchar(30) NOT NULL COMMENT '系统编码',
	remark varchar(100) COMMENT '备注',
	create_by varchar(50) COMMENT '创建人',
	create_date datetime COMMENT '创建时间',
	last_update_by varchar(50) COMMENT '最新更新人',
	last_update_date datetime COMMENT '最新更新时间',
	PRIMARY KEY (id, code),
	UNIQUE (code)
) COMMENT = '子系统';


-- 系统资源表
CREATE TABLE sys_resource
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
	code varchar(30) COMMENT '编码',
	long_code varchar(150) COMMENT '长编码',
	status int(1) COMMENT '状态(1:启用,2:禁用)',
	sub_system_code varchar(30) COMMENT '关联子系统',
	parent_code varchar(30) COMMENT '父编码',
	url varchar(60) COMMENT '访问路径',
	is_menu int(1) DEFAULT 1 COMMENT '1:菜单,2:权限项',
	orders int(11) DEFAULT 0 COMMENT '排序字段',
	level int(2) COMMENT '级别',
	icon_code varchar(30) COMMENT '菜单样式',
	permission varchar(50) COMMENT '权限标识',
	create_by varchar(50) COMMENT '创建人',
	create_date datetime COMMENT '创建时间',
	last_update_by varchar(50) COMMENT '最新更新人',
	last_update_date datetime COMMENT '最新更新时间',
	PRIMARY KEY (id)
) COMMENT = '系统资源表';


-- 系统角色表
CREATE TABLE sys_role
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
	code varchar(30) COMMENT '编码',
	name varchar(30) COMMENT '名称',
	status int(1) COMMENT '状态(1:启用,2:禁用)',
	role_type varchar(30) COMMENT '角色类型',
	remark varchar(120) COMMENT '备注',
	create_by varchar(50) COMMENT '创建人',
	create_date datetime COMMENT '创建时间',
	last_update_by varchar(50) COMMENT '最新更新人',
	last_update_date datetime COMMENT '最新更新时间',
	PRIMARY KEY (id)
) COMMENT = '系统角色表';


-- 系统角色资源关联表
CREATE TABLE sys_role_resource
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
	role_code varchar(30) COMMENT '角色编码',
	resource_code varchar(30) COMMENT '资源编码',
	PRIMARY KEY (id)
) COMMENT = '系统角色资源关联表';


-- 系统用户表
CREATE TABLE sys_user
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
	username varchar(50) COMMENT '用户名',
	password varchar(100) COMMENT '密码',
	name varchar(30) COMMENT '名称',
	status int(1) COMMENT '状态(1:启用,2:禁用)',
	email varchar(100) COMMENT '邮箱',
	default_role varchar(30) COMMENT '默认角色',
	create_by varchar(50) COMMENT '创建人',
	create_date datetime COMMENT '创建时间',
	last_update_by varchar(50) COMMENT '最新更新人',
	last_update_date datetime COMMENT '最新更新时间',
	PRIMARY KEY (id)
) COMMENT = '系统用户表';
