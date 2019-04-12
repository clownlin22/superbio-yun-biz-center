/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : jcb

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-04-12 11:01:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auth_data_limit`
-- ----------------------------
DROP TABLE IF EXISTS `auth_data_limit`;
CREATE TABLE `auth_data_limit` (
  `id` bigint(20) unsigned NOT NULL,
  `resource_name` varchar(100) NOT NULL COMMENT '资源名称',
  `table_name` varchar(100) NOT NULL COMMENT '表名称',
  `scope` tinyint(4) NOT NULL DEFAULT '0' COMMENT '数据范围：只自己，本部门，下级部门（包括本部门），指定部门，全部',
  `dept_ids` varchar(200) NOT NULL COMMENT '当数据范围是指定部门时，保存指定部门的ids',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_data_limit
-- ----------------------------

-- ----------------------------
-- Table structure for `auth_dept`
-- ----------------------------
DROP TABLE IF EXISTS `auth_dept`;
CREATE TABLE `auth_dept` (
  `id` bigint(20) unsigned NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '部门类型',
  `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '父级ID',
  `parent_ids` varchar(100) DEFAULT NULL COMMENT '父级名称',
  `tree_sort` int(11) DEFAULT NULL COMMENT '父级名称',
  `tree_sorts` varchar(255) DEFAULT NULL COMMENT '父级名称',
  `tree_leaf` tinyint(4) DEFAULT '0' COMMENT '有无下级',
  `tree_depth` tinyint(4) DEFAULT '0' COMMENT '----',
  `tree_names` varchar(255) DEFAULT NULL COMMENT '----',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_dept
-- ----------------------------
INSERT INTO `auth_dept` VALUES ('1001', '11', '1', '1001', '0,', '11', '0000000090,', '1', '0', '营销部');
INSERT INTO `auth_dept` VALUES ('1113249202306371586', '22', '1', '1113249202306371586', '0,,1001', '22', '0000000090,,0000000012', '1', '-1', '营销部/网');
INSERT INTO `auth_dept` VALUES ('1113258143824302081', '122', '3', '1113249202306371586', '0,,1001,1113249202306371586', '11', '0000000090,,0000000012,0000000011', '0', '-2', '营销部/网/11');
INSERT INTO `auth_dept` VALUES ('1113295857256845314', '网111', '1', '0', '0', '111', '0000000111', '0', '0', '网111');
INSERT INTO `auth_dept` VALUES ('1116517435092267009', '33', '2', '1116517435092267009', '0', '333', '0000000111', '0', '0', '111');
INSERT INTO `auth_dept` VALUES ('1116535623075016706', '123', '1', '1113249202306371586', '0,,1001,1113249202306371586', '123', '0000000090,,0000000012,0000000123', '0', '-2', '营销部/网/123');
INSERT INTO `auth_dept` VALUES ('1116535825190137857', '11', '1', '0', '0', '22', '0000000022', '1', '0', '11');
INSERT INTO `auth_dept` VALUES ('1116535857838600193', '22', '1', '1116535825190137857', '0,1116535825190137857', '22', '0000000022,0000000022', '1', '-1', '11/22');
INSERT INTO `auth_dept` VALUES ('1116535899769057281', '22', '0', '1116535857838600193', '0,1116535825190137857,1116535857838600193', '22', '0000000022,0000000022,0000000022', '1', '-2', '11/22/22');
INSERT INTO `auth_dept` VALUES ('1116535950755016705', '222', '1', '1116535899769057281', '0,1116535825190137857,1116535857838600193,1116535899769057281', '222', '0000000022,0000000022,0000000022,0000000222', '1', '-3', '11/22/22/222');
INSERT INTO `auth_dept` VALUES ('1116535997643141122', '33', '1', '1116535899769057281', '0,1116535825190137857,1116535857838600193,1116535899769057281', '333', '0000000022,0000000022,0000000022,0000000333', '0', '-3', '11/22/22/33');
INSERT INTO `auth_dept` VALUES ('1116536247653019650', '44', '3', '1116535950755016705', '0,1116535825190137857,1116535857838600193,1116535899769057281,1116535950755016705', '44', '0000000022,0000000022,0000000022,0000000222,0000000044', '0', '-4', '11/22/22/222/44');
INSERT INTO `auth_dept` VALUES ('1116536296957063170', '55', '3', '1116535857838600193', '0,1116535825190137857,1116535857838600193', '55', '0000000022,0000000022,0000000055', '0', '-2', '11/22/55');

-- ----------------------------
-- Table structure for `auth_dept_user`
-- ----------------------------
DROP TABLE IF EXISTS `auth_dept_user`;
CREATE TABLE `auth_dept_user` (
  `id` bigint(20) unsigned NOT NULL,
  `dept_id` bigint(20) unsigned NOT NULL COMMENT '部门编号',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户编号',
  `default` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '是否默认',
  PRIMARY KEY (`id`),
  KEY `fk_auth_dept_auth_dept_user_1` (`dept_id`),
  KEY `fk_auth_dept_user_auth_user_1` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_dept_user
-- ----------------------------
INSERT INTO `auth_dept_user` VALUES ('1110472635553513473', '1075257789165957122', '1110065957599215618', '0');
INSERT INTO `auth_dept_user` VALUES ('1110472700871409666', '1075309114796896257', '1110065341325934593', '0');
INSERT INTO `auth_dept_user` VALUES ('1115524773484703746', '1113295857256845314', '1115069007258816514', '0');
INSERT INTO `auth_dept_user` VALUES ('1115524793332150274', '1113295857256845314', '1115069263253966849', '0');
INSERT INTO `auth_dept_user` VALUES ('1115844160028700674', '1113295857256845314', '1115069378148536321', '0');
INSERT INTO `auth_dept_user` VALUES ('1116163748926963713', '1113249202306371586', '1113295535067189249', '0');

-- ----------------------------
-- Table structure for `auth_permission`
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission` (
  `id` bigint(20) unsigned NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '权限名称',
  `code` varchar(100) NOT NULL COMMENT '权限编码',
  `type` tinyint(4) NOT NULL COMMENT '类型',
  `description` varchar(200) NOT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_permission
-- ----------------------------
INSERT INTO `auth_permission` VALUES ('0', '权限名称1', '权限编号112', '1', '权限描述1');
INSERT INTO `auth_permission` VALUES ('1075943487892148226', '权限名称2222', '权限编号2222', '1', '权限描述2');
INSERT INTO `auth_permission` VALUES ('1076034484810608641', '权限名称3', '权限编号3', '0', '权限描述3');
INSERT INTO `auth_permission` VALUES ('1076034525260476418', '权限名称4', '权限编号41', '1', '权限描述4');
INSERT INTO `auth_permission` VALUES ('1116517996847984641', '22', '22', '1', '22');

-- ----------------------------
-- Table structure for `auth_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `id` bigint(20) unsigned NOT NULL,
  `code` varchar(100) NOT NULL COMMENT '角色编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `description` varchar(100) NOT NULL COMMENT '角色描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `systemic` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为系统内置',
  `enabled` tinyint(4) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES ('1', '12', '总经理', '这里是角色描述这里是角色描述这里是角色描述这里是角色描述这里是角色描述这里是角色描述这里是角色描述这里是角色描述这里是角色描述这里是角色描述这里是角色描述', '6', '0', '0');
INSERT INTO `auth_role` VALUES ('2', '2', '副总', '2', '2', '0', '1');
INSERT INTO `auth_role` VALUES ('123', '11', '经理', '123', '3', '0', '1');
INSERT INTO `auth_role` VALUES ('1110718026739912706', '01', '名称', '这里是角色描述', '1', '0', '1');
INSERT INTO `auth_role` VALUES ('1110726167187722242', '12', '12', '1212', '12', '1', '1');
INSERT INTO `auth_role` VALUES ('1110726646244347905', '123', '123', '123123', '123', '1', '1');

-- ----------------------------
-- Table structure for `auth_role_data_limit`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_data_limit`;
CREATE TABLE `auth_role_data_limit` (
  `id` bigint(20) unsigned NOT NULL,
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色编号',
  `data_limit_id` bigint(20) unsigned NOT NULL COMMENT '数据权限编号',
  PRIMARY KEY (`id`),
  KEY `fk_auth_role_data_limit_auth_role_1` (`role_id`),
  KEY `fk_auth_role_data_limit_auth_data_limit_1` (`data_limit_id`),
  CONSTRAINT `auth_role_data_limit_ibfk_1` FOREIGN KEY (`data_limit_id`) REFERENCES `auth_data_limit` (`id`),
  CONSTRAINT `auth_role_data_limit_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role_data_limit
-- ----------------------------

-- ----------------------------
-- Table structure for `auth_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_permission`;
CREATE TABLE `auth_role_permission` (
  `id` bigint(20) unsigned NOT NULL,
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色编号',
  `permission_id` bigint(20) unsigned NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`),
  KEY `fk_auth_role_auth_role_permission_1` (`role_id`),
  KEY `fk_auth_role_permission_auth_permission_1` (`permission_id`),
  CONSTRAINT `auth_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`),
  CONSTRAINT `auth_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role_permission
-- ----------------------------
INSERT INTO `auth_role_permission` VALUES ('1115157255343661057', '123', '0');
INSERT INTO `auth_role_permission` VALUES ('1115157255343661058', '123', '1075943487892148226');
INSERT INTO `auth_role_permission` VALUES ('1115157255343661059', '123', '1076034484810608641');
INSERT INTO `auth_role_permission` VALUES ('1115157255343661060', '123', '1076034525260476418');
INSERT INTO `auth_role_permission` VALUES ('1115157272104099842', '1110718026739912706', '0');
INSERT INTO `auth_role_permission` VALUES ('1115157272120877057', '1110718026739912706', '1075943487892148226');
INSERT INTO `auth_role_permission` VALUES ('1115157272120877058', '1110718026739912706', '1076034484810608641');
INSERT INTO `auth_role_permission` VALUES ('1115157272120877059', '1110718026739912706', '1076034525260476418');
INSERT INTO `auth_role_permission` VALUES ('1115844996800737281', '1', '1076034525260476418');
INSERT INTO `auth_role_permission` VALUES ('1115845009165545474', '2', '1075943487892148226');
INSERT INTO `auth_role_permission` VALUES ('1115845021052203010', '1110726167187722242', '0');
INSERT INTO `auth_role_permission` VALUES ('1115845021052203011', '1110726167187722242', '1075943487892148226');

-- ----------------------------
-- Table structure for `auth_user`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user` (
  `id` bigint(20) unsigned NOT NULL,
  `login_name` varchar(100) NOT NULL COMMENT '登录名称',
  `name` varchar(100) NOT NULL COMMENT '用户昵称',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `phone` char(20) NOT NULL COMMENT '联系方式',
  `email` varchar(100) NOT NULL COMMENT '用户邮箱',
  `enabled` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES ('1113295535067189249', '123', '123', '888888', '123', '12', '1');
INSERT INTO `auth_user` VALUES ('1115069007258816514', 'loginName', 'name', '888888', 'phone', 'email', '1');
INSERT INTO `auth_user` VALUES ('1115069263253966849', '11', '22', '888888', '33', '44', '1');
INSERT INTO `auth_user` VALUES ('1115069378148536321', '22', '33', '888888', '44', '55', '1');

-- ----------------------------
-- Table structure for `auth_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role` (
  `id` bigint(20) unsigned NOT NULL,
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`),
  KEY `fk_auth_user_auth_user_role_1` (`user_id`),
  KEY `fk_auth_user_role_auth_role_1` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------
INSERT INTO `auth_user_role` VALUES ('1115805184215547906', '1115069263253966849', '1110726167187722242');
INSERT INTO `auth_user_role` VALUES ('1115805184215547908', '1115069007258816514', '1110726167187722242');
INSERT INTO `auth_user_role` VALUES ('1115818000792186882', '1115069007258816514', '2');
INSERT INTO `auth_user_role` VALUES ('1115844953175781377', '1115069378148536321', '1110718026739912706');
INSERT INTO `auth_user_role` VALUES ('1115844953175781378', '1115069007258816514', '1110718026739912706');
INSERT INTO `auth_user_role` VALUES ('1115844953188364289', '1115069263253966849', '1110718026739912706');
INSERT INTO `auth_user_role` VALUES ('1115844985425784833', '1115069378148536321', '123');
INSERT INTO `auth_user_role` VALUES ('1115844985425784834', '1115069007258816514', '123');
INSERT INTO `auth_user_role` VALUES ('1115844985425784835', '1115069263253966849', '123');
INSERT INTO `auth_user_role` VALUES ('1116163748230709250', '1113295535067189249', '1110718026739912706');
INSERT INTO `auth_user_role` VALUES ('1116163748239097857', '1113295535067189249', '2');
INSERT INTO `auth_user_role` VALUES ('1116163748239097858', '1113295535067189249', '1110726167187722242');
INSERT INTO `auth_user_role` VALUES ('1116163748239097859', '1113295535067189249', '1110726646244347905');
INSERT INTO `auth_user_role` VALUES ('1116511668628910081', '1115069378148536321', '1');
INSERT INTO `auth_user_role` VALUES ('1116511668641492993', '1115069263253966849', '1');
INSERT INTO `auth_user_role` VALUES ('1116511668641492994', '1115069007258816514', '1');

-- ----------------------------
-- Table structure for `databasechangelog`
-- ----------------------------
DROP TABLE IF EXISTS `databasechangelog`;
CREATE TABLE `databasechangelog` (
  `ID` varchar(255) COLLATE utf8_bin NOT NULL,
  `AUTHOR` varchar(255) COLLATE utf8_bin NOT NULL,
  `FILENAME` varchar(255) COLLATE utf8_bin NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) COLLATE utf8_bin NOT NULL,
  `MD5SUM` varchar(35) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `COMMENTS` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TAG` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LIQUIBASE` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `CONTEXTS` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LABELS` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of databasechangelog
-- ----------------------------
INSERT INTO `databasechangelog` VALUES ('V01__init_schema', 'FuDong', 'classpath:db/changelog/spbbase/authcenter/V01__init_schema.xml', '2019-03-27 15:43:01', '1', 'EXECUTED', '7:7884626f0323f4c8aedc9b940d4da151', 'createTable tableName=spbbase_district', '', null, '3.5.4', null, null, '3672580914');

-- ----------------------------
-- Table structure for `databasechangelog_copy`
-- ----------------------------
DROP TABLE IF EXISTS `databasechangelog_copy`;
CREATE TABLE `databasechangelog_copy` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of databasechangelog_copy
-- ----------------------------

-- ----------------------------
-- Table structure for `databasechangeloglock`
-- ----------------------------
DROP TABLE IF EXISTS `databasechangeloglock`;
CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of databasechangeloglock
-- ----------------------------
INSERT INTO `databasechangeloglock` VALUES ('1', '', null, null);

-- ----------------------------
-- Table structure for `databasechangeloglock_copy`
-- ----------------------------
DROP TABLE IF EXISTS `databasechangeloglock_copy`;
CREATE TABLE `databasechangeloglock_copy` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of databasechangeloglock_copy
-- ----------------------------
INSERT INTO `databasechangeloglock_copy` VALUES ('1', '', null, null);

-- ----------------------------
-- Table structure for `jcb_case`
-- ----------------------------
DROP TABLE IF EXISTS `jcb_case`;
CREATE TABLE `jcb_case` (
  `id` bigint(20) unsigned NOT NULL,
  `status` tinyint(4) DEFAULT '0' COMMENT '状态',
  `case_category_id` bigint(20) unsigned NOT NULL COMMENT '专业类别',
  `entrust_date` date DEFAULT NULL COMMENT '委托时间',
  `accept_date` date DEFAULT NULL COMMENT '受理时间',
  `deadline` smallint(6) DEFAULT NULL COMMENT '落案时间',
  `case_sign` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '案件标志',
  `case_no_auto_generate` bit(1) DEFAULT NULL COMMENT '案件编号是否自动生成',
  `case_no` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '案件编号',
  `identified_before` bit(1) DEFAULT NULL COMMENT '既往鉴定史',
  `urgent` bit(1) DEFAULT NULL COMMENT '是否加急',
  `need_evade` bit(1) DEFAULT NULL COMMENT '是否回避',
  `materials_completed` bit(1) DEFAULT NULL COMMENT '材料齐全',
  `case_summary` varchar(1000) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '检案摘要',
  `remark` varchar(500) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '备注',
  `client_type` tinyint(4) DEFAULT NULL COMMENT '委托方类型',
  `client_dept` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '委托单位',
  `client_name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '委托人姓名',
  `client_phone` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '委托人联系电话',
  `client_address` varchar(500) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '委托人地址',
  `report_provided_type` tinyint(4) DEFAULT NULL COMMENT '报告发放方式',
  `cert_type_for_took` tinyint(4) DEFAULT NULL COMMENT '备注',
  `cert_identify` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '凭证号（如身份证）',
  `recipient_name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '收件人',
  `recipient_phone` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '收件人联系电话',
  `recipient_address` varchar(500) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '收件人地址',
  `total_price` int(11) DEFAULT NULL COMMENT '备注',
  `report_path` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '报告路径',
  `download_count` smallint(6) DEFAULT '0' COMMENT '下载次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jcb_case
-- ----------------------------
INSERT INTO `jcb_case` VALUES ('213', '12', '5', '2018-10-08', '2018-10-22', '5', '痕鉴字', '', 'ZZZ123123', '', '', '', '', '检案摘要1', '备注', '1', '委托单位1', '委托人', '18206183516', '委托方住址1', '1', '2', '320322199411111111', '', '', '', '2324', '', '0');
INSERT INTO `jcb_case` VALUES ('1102403048215674881', '1', '2', '2019-03-03', '2019-03-10', '1', '痕鉴字', '', 'ZX123456', '', '', '', '', '检案摘要\n', '备注', '0', '', '委托人', '18206183516', '委托方住址1', '1', '0', '', '', '', '', '620', '', '0');
INSERT INTO `jcb_case` VALUES ('1102404352816185345', '3', '4', '2019-03-05', '2019-03-02', '2', '毒鉴字', '', 'ZX123', '', '', '', '', '摘要', '备注', '1', '委托单位2', '委托人', '18206183516', '委托方住址1', '2', null, '', '收件人', '收件人联系方式', '收件人地址', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1102407959691132930', '0', '2', '2019-03-05', '2019-02-28', '2', '痕鉴字', '', 'YLSB456', '', '', '', '', '检案摘要\n', '备注\n', '1', '委托单位2', ' 委托单位 委托人1', '18206183516', '委托方住址1', '2', null, '', '收件人', '收件人联系方式', '收件人地址', '458', '', '0');
INSERT INTO `jcb_case` VALUES ('1102408446054236162', '0', '0', '2018-12-13', '2018-12-28', '2', '毒鉴字', '', 'YLSB111', '', '', '', '', '检案摘要\n', '备注', '1', '委托单位3', '委托人', '18206183516', '委托方住址1', '1', '0', '', '', '', '', '275', '', '0');
INSERT INTO `jcb_case` VALUES ('1102409451940610050', '0', '3', '2019-03-14', '2019-03-15', '2', '病鉴字', '', 'ZX456456', '', '', '', '', '检案摘要', '备注', '1', '委托单位4', '委托人', '18206183516', '委托方住址2', '0', null, '', '收件人', '收件人联系方式', '收件人地址', '276', '', '0');
INSERT INTO `jcb_case` VALUES ('1102440640491552769', '0', '0', '2019-02-24', '2019-02-27', '1', '病鉴字', '', 'XW20190304', '', '', '', '', '', '备注', '0', '', '委托人', '18206183516', '委托方住址', '1', '1', '', '', '', '', '21', '', '0');
INSERT INTO `jcb_case` VALUES ('1102472265099116546', '0', '3', '2019-03-14', '2019-03-14', '2', '病鉴字', '', 'ZX001', '', '', '', '', '检案摘要', '备注', '1', '委托单位1', '委托人', '18206183516', '委托方住址1', '1', '1', '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1102745483605245954', '0', '2', '2019-03-08', '2019-03-07', '2', '毒鉴字', '', 'ZX121212', '', '', '', '', '检案摘要', '备注', '0', '', '委托人', '18206183516', '委托方住址', '1', '0', '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1102763807055609858', '0', '0', '2019-02-26', '2019-03-05', '2', '病鉴字', '', 'WSSB123', '', '', '', '', '', '备注', '1', '委托单位3', '委托人', '18206183516', '委托方住址1', '1', '1', '', '', '', '', '3220', '', '0');
INSERT INTO `jcb_case` VALUES ('1102764594829787137', '0', '0', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1102765534299357185', '0', '0', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1102766429200252930', '0', '0', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1102767128671748098', '0', '0', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1102768108402442242', '0', '0', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1102769724677488642', '0', '0', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1103586087847456769', '0', '5', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', null, '', '0');
INSERT INTO `jcb_case` VALUES ('1103586475799605250', '0', '0', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1104913485192822785', '0', '1', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1104982601282945025', '0', '3', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1104983084252856322', '0', '2', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1104983542224715778', '0', '5', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '5964', '', '0');
INSERT INTO `jcb_case` VALUES ('1104983680775159810', '0', '1', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1104983750392217601', '0', '2', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1105013928703098882', '0', '2', null, null, null, '痕鉴字', '', 'ZX123456789', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1112883312243056641', '0', '3', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1112883867069784065', '0', '3', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');
INSERT INTO `jcb_case` VALUES ('1112883867124310018', '0', '4', null, null, null, '', '', '', null, null, null, null, '', '', null, '', '', '', '', null, null, '', '', '', '', '0', '', '0');

-- ----------------------------
-- Table structure for `jcb_case_charging`
-- ----------------------------
DROP TABLE IF EXISTS `jcb_case_charging`;
CREATE TABLE `jcb_case_charging` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `case_id` bigint(20) unsigned DEFAULT NULL COMMENT '案例编号',
  `charging_item_id` bigint(20) unsigned DEFAULT NULL COMMENT '案件类别编号',
  `amount` tinyint(4) DEFAULT NULL COMMENT '数量',
  `discount` int(11) DEFAULT NULL COMMENT '优惠金额（单位分）',
  `total_price` int(11) DEFAULT NULL COMMENT '应收小计（单位分）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1105281277830156291 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jcb_case_charging
-- ----------------------------
INSERT INTO `jcb_case_charging` VALUES ('1101388488365064194', '213', '4', '2', '0', '578');
INSERT INTO `jcb_case_charging` VALUES ('1102409452204851201', '1102409451940610050', '2', '2', '0', '276');
INSERT INTO `jcb_case_charging` VALUES ('1102456242010587137', '1102403048215674881', '1', '1', '0', '344');
INSERT INTO `jcb_case_charging` VALUES ('1102456242010587138', '1102403048215674881', '2', '2', '0', '276');
INSERT INTO `jcb_case_charging` VALUES ('1102456958502567937', '213', '2', '6', '0', '828');
INSERT INTO `jcb_case_charging` VALUES ('1103482680809644034', '213', '3', '1', '0', '498');
INSERT INTO `jcb_case_charging` VALUES ('1103586088044589059', '1103586087847456769', '5', '1', '0', '156');
INSERT INTO `jcb_case_charging` VALUES ('1104983574868983809', '1104983542224715778', '0', '12', '0', '5964');
INSERT INTO `jcb_case_charging` VALUES ('1105018482081464321', '213', '2', '1', '0', '280');
INSERT INTO `jcb_case_charging` VALUES ('1105018527036014594', '1102408446054236162', '4', '1', '0', '275');
INSERT INTO `jcb_case_charging` VALUES ('1105019190419718146', '1102763807055609858', '2', '2', '0', '560');
INSERT INTO `jcb_case_charging` VALUES ('1105019648383188994', '1102763807055609858', '4', '3', '0', '825');
INSERT INTO `jcb_case_charging` VALUES ('1105019648383188995', '1102763807055609858', '5', '5', '0', '1835');
INSERT INTO `jcb_case_charging` VALUES ('1105281277830156290', '213', '0', '1', '0', '140');

-- ----------------------------
-- Table structure for `jcb_case_material`
-- ----------------------------
DROP TABLE IF EXISTS `jcb_case_material`;
CREATE TABLE `jcb_case_material` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `case_id` bigint(20) unsigned DEFAULT NULL COMMENT '案例编号',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '材料名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型',
  `amount` tinyint(4) DEFAULT NULL COMMENT '数量',
  `specification` tinyint(4) DEFAULT NULL COMMENT '规格',
  `feature` tinyint(4) DEFAULT NULL COMMENT '材料性质',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `attachment_id` bigint(20) DEFAULT NULL COMMENT '上传的文件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1105019648882311170 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jcb_case_material
-- ----------------------------
INSERT INTO `jcb_case_material` VALUES ('1101302465572470786', null, '12', '2', '12', '3', '2', '12', '1101302412858351618');
INSERT INTO `jcb_case_material` VALUES ('1101322928394616834', null, '12', '3', '12', '2', '2', '12', '1101322930831405057');
INSERT INTO `jcb_case_material` VALUES ('1102469864375975937', '1102404352816185345', '鉴定材料', '1', '2', '2', '2', '12', '1102469866460442626');
INSERT INTO `jcb_case_material` VALUES ('1103215708108800001', '1102404352816185345', '12', '1', '12', '1', '1', '12', '1103215703289438210');
INSERT INTO `jcb_case_material` VALUES ('1103586502693482497', '1103586475799605250', '123', '1', '123', '1', '1', '123', null);
INSERT INTO `jcb_case_material` VALUES ('1103825523839410178', '213', '123', '1', '123', '2', '2', '123', null);
INSERT INTO `jcb_case_material` VALUES ('1104913485385760770', '1104913485192822785', '12', '1', '12', '2', '1', '12', '123456');
INSERT INTO `jcb_case_material` VALUES ('1104982608618782721', '1104982601282945025', '13', '1', '13', '2', '1', '13', '1104982601995808770');
INSERT INTO `jcb_case_material` VALUES ('1104983110400147458', '1104983084252856322', '123', '2', '12', '2', '2', '12', '1104983001662648322');
INSERT INTO `jcb_case_material` VALUES ('1104983575154196482', '1104983542224715778', '13', '2', '13', '2', '2', '13', '1104983508686893057');
INSERT INTO `jcb_case_material` VALUES ('1104983750606127105', '1104983750392217601', '1', '1', '0', '1', '1', '1', '1104983749674823682');
INSERT INTO `jcb_case_material` VALUES ('1105019648882311169', '1102763807055609858', '12', '2', '2', '1', '1', '123', '1105019649305767938');

-- ----------------------------
-- Table structure for `jcb_case_sample`
-- ----------------------------
DROP TABLE IF EXISTS `jcb_case_sample`;
CREATE TABLE `jcb_case_sample` (
  `id` bigint(20) unsigned NOT NULL,
  `case_id` bigint(20) DEFAULT NULL COMMENT '案例编号',
  `sample_id` bigint(20) DEFAULT NULL COMMENT '样本编号',
  `appellation` tinyint(4) DEFAULT NULL COMMENT '称谓',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jcb_case_sample
-- ----------------------------
INSERT INTO `jcb_case_sample` VALUES ('1105018528952811521', '1102408446054236162', '1103860008651870210', '2');
INSERT INTO `jcb_case_sample` VALUES ('1105018528952811522', '1102408446054236162', '1103893780982157313', '1');
INSERT INTO `jcb_case_sample` VALUES ('1105019649863778306', '1102763807055609858', '1105019649708589057', '2');

-- ----------------------------
-- Table structure for `jcb_identification_matter`
-- ----------------------------
DROP TABLE IF EXISTS `jcb_identification_matter`;
CREATE TABLE `jcb_identification_matter` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `case_id` bigint(20) unsigned DEFAULT NULL COMMENT '案例编号',
  `entrusted_matter_id` bigint(20) DEFAULT NULL COMMENT '委托事项',
  `amount` tinyint(4) DEFAULT NULL COMMENT '数量',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1105281278673211394 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jcb_identification_matter
-- ----------------------------
INSERT INTO `jcb_identification_matter` VALUES ('1102409452355846146', '1102409451940610050', '2', '2', '123');
INSERT INTO `jcb_identification_matter` VALUES ('1102456242450989058', '1102403048215674881', '1', '1', '1');
INSERT INTO `jcb_identification_matter` VALUES ('1102456242450989059', '1102403048215674881', '2', '2', '2');
INSERT INTO `jcb_identification_matter` VALUES ('1102456959001690114', '213', '2', '6', '6');
INSERT INTO `jcb_identification_matter` VALUES ('1102469864543748098', '1102404352816185345', '1', '1', '1');
INSERT INTO `jcb_identification_matter` VALUES ('1102469864552136705', '1102404352816185345', '3', '3', '3');
INSERT INTO `jcb_identification_matter` VALUES ('1102469864552136706', '1102404352816185345', '3', '4', '4');
INSERT INTO `jcb_identification_matter` VALUES ('1103894862370197506', '1102440640491552769', '0', '1', '1');
INSERT INTO `jcb_identification_matter` VALUES ('1104983575389077505', '1104983542224715778', '0', '12', '12');
INSERT INTO `jcb_identification_matter` VALUES ('1105019190595878914', '1102763807055609858', '2', '2', '2');
INSERT INTO `jcb_identification_matter` VALUES ('1105019649066860546', '1102763807055609858', '4', '3', '3');
INSERT INTO `jcb_identification_matter` VALUES ('1105019649066860547', '1102763807055609858', '5', '5', '5');
INSERT INTO `jcb_identification_matter` VALUES ('1105281278673211393', '213', '0', '1', '1');

-- ----------------------------
-- Table structure for `jcb_identified_car`
-- ----------------------------
DROP TABLE IF EXISTS `jcb_identified_car`;
CREATE TABLE `jcb_identified_car` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `case_id` bigint(20) unsigned DEFAULT NULL COMMENT '案例编号',
  `plate_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '车牌号',
  `brand` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '车辆品牌',
  `type` tinyint(4) DEFAULT NULL COMMENT '车辆类型',
  `vin` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '车架号',
  `engine_number` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '发动机号',
  `parking_place` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '停放地点',
  `contact_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1103824298112786434 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jcb_identified_car
-- ----------------------------
INSERT INTO `jcb_identified_car` VALUES ('1103824298112786433', '213', '123', '123', '0', '123', '123', '123', '123', '13500000000', '123');

-- ----------------------------
-- Table structure for `jcb_identified_object`
-- ----------------------------
DROP TABLE IF EXISTS `jcb_identified_object`;
CREATE TABLE `jcb_identified_object` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `case_id` bigint(20) unsigned DEFAULT NULL COMMENT '案例编号',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `contact_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1101388489547857922 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jcb_identified_object
-- ----------------------------
INSERT INTO `jcb_identified_object` VALUES ('1101388489547857921', '213', '11', '11', '13500000000', '11');

-- ----------------------------
-- Table structure for `jcb_identified_person`
-- ----------------------------
DROP TABLE IF EXISTS `jcb_identified_person`;
CREATE TABLE `jcb_identified_person` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `case_id` bigint(20) unsigned NOT NULL COMMENT '案例编号',
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `age` tinyint(4) DEFAULT NULL COMMENT '年龄',
  `address` varchar(500) COLLATE utf8_bin NOT NULL COMMENT '家庭住址',
  `id_number` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '身份证号',
  `contact_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '联系人',
  `contact_phone` varchar(500) COLLATE utf8_bin NOT NULL COMMENT '联系电话',
  `nation` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '民族',
  `remark` varchar(500) COLLATE utf8_bin NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1105019649536622595 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jcb_identified_person
-- ----------------------------
INSERT INTO `jcb_identified_person` VALUES ('1103579283281276929', '1102404352816185345', '123', '0', '123', '123', '123', '123', '123', '123', '123');
INSERT INTO `jcb_identified_person` VALUES ('1103824298502856705', '213', '123', '0', '123', '123', '320322199411111111', '123', '13500000000', '123', '123');
INSERT INTO `jcb_identified_person` VALUES ('1103860008488292354', '1102408446054236162', '123', '0', '123', '123', '123', '123', '12', '123', '123');
INSERT INTO `jcb_identified_person` VALUES ('1103893780659195905', '1102408446054236162', '乔治', '0', '24', '13', '320322199411296556', '12', '12', '汉族', '12');
INSERT INTO `jcb_identified_person` VALUES ('1103894862500220929', '1102440640491552769', '12', '0', '12', '12', '320322199411296556', '12', '12', '12', '12');
INSERT INTO `jcb_identified_person` VALUES ('1105019649536622594', '1102763807055609858', '12', '0', '12', '12', '320322111111111111', '12', '13500000000', '12', '12');

-- ----------------------------
-- Table structure for `jcb_sample`
-- ----------------------------
DROP TABLE IF EXISTS `jcb_sample`;
CREATE TABLE `jcb_sample` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sample_code` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '样本编号',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `id_number` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `age` tinyint(4) DEFAULT NULL COMMENT '年龄',
  `address` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '家庭地址',
  `special` bit(1) DEFAULT NULL COMMENT '是否特殊样本',
  `sample_type` tinyint(4) DEFAULT NULL COMMENT '样本类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1105019649708589058 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jcb_sample
-- ----------------------------
INSERT INTO `jcb_sample` VALUES ('1103860008651870210', '123123', '123', '123', null, '123', '123', '', '1');
INSERT INTO `jcb_sample` VALUES ('1103893780982157313', '1231', '乔治', '320322199411296556', null, '24', '13', '', '1');
INSERT INTO `jcb_sample` VALUES ('1105019649708589057', '123123', '12', '320322111111111111', '1111-11-11', '12', '12', '', '1');

-- ----------------------------
-- Table structure for `oauth_client_details`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL,
  `resource_ids` varchar(255) NOT NULL,
  `client_secret` varchar(255) NOT NULL COMMENT '密码',
  `scope` varchar(255) NOT NULL,
  `authorized_grant_types` varchar(255) NOT NULL COMMENT '支持的授权方式',
  `web_server_redirect_uri` varchar(255) NOT NULL,
  `authorities` varchar(255) NOT NULL,
  `access_token_validity` int(11) NOT NULL COMMENT 'access_token有效期（单位秒）',
  `refresh_token_validity` int(11) NOT NULL COMMENT 'refresh_token有效期（单位秒）',
  `additional_information` varchar(255) NOT NULL,
  `autoapprove` varchar(255) NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------

-- ----------------------------
-- Table structure for `spbbase_attachment`
-- ----------------------------
DROP TABLE IF EXISTS `spbbase_attachment`;
CREATE TABLE `spbbase_attachment` (
  `id` bigint(20) NOT NULL,
  `enabled` int(11) DEFAULT NULL,
  `biz_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `biz_id` bigint(20) DEFAULT NULL,
  `file_path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `file_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `file_extension` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `file_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `file_content_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `file_md5` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of spbbase_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for `spbbase_district`
-- ----------------------------
DROP TABLE IF EXISTS `spbbase_district`;
CREATE TABLE `spbbase_district` (
  `code` char(10) COLLATE utf8_bin NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '????',
  `pinyin` varchar(200) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '??',
  `jianpin` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '??',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '????',
  `parent_code` char(10) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '????',
  `parent_codes` varchar(55) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '??????',
  `tree_sort` int(11) NOT NULL DEFAULT '0' COMMENT '?????',
  `tree_sorts` varchar(400) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '???????',
  `tree_leaf` int(11) NOT NULL DEFAULT '1' COMMENT '?????',
  `tree_depth` int(11) NOT NULL DEFAULT '0' COMMENT '??????0???',
  `tree_names` varchar(300) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '????',
  `remark` varchar(200) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '??',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='?????';

-- ----------------------------
-- Records of spbbase_district
-- ----------------------------
INSERT INTO `spbbase_district` VALUES ('110000', '北京市', 'iiiiiiiiii', 'BJ', '1', '0', '0,', '10', '0000000010', '1', '0', '北京市', '1');
INSERT INTO `spbbase_district` VALUES ('110100', '北京城区', 'beijingchengqu', 'BJCQ', '2', '110000', '0,110000,', '50', '0000000010,0000000050,', '1', '1', '北京市/北京城区', '备注');
INSERT INTO `spbbase_district` VALUES ('110101', '东城区 ', 'dongchengqu', 'DCQ', '3', '110100', '0,110000,110100,', '10', '0000000010,0000000010,0000000010,', '0', '2', '北京市/北京城区/东城区 ', '备注');
INSERT INTO `spbbase_district` VALUES ('110102', '西城区', 'xichengqu', 'XCQ', '3', '110100', '0,110000,110100,', '20', '0000000010,0000000010,0000000020,', '0', '2', '北京市/北京城区/西城区', '备注');
INSERT INTO `spbbase_district` VALUES ('2', '3', '123', '123', '1', '', '1', '0', '123', '1', '0', '123', '123');
INSERT INTO `spbbase_district` VALUES ('320000', '江苏省', 'JSS', 'JSS', '1', '0', '0,', '20', '0000000020', '0', '0', '江苏省', '');
INSERT INTO `spbbase_district` VALUES ('342201', '安徽省', 'hhhh', 'sfsdfsdf', '1', '0', '0,', '30', '0000000030', '0', '0', '安徽省', '');
INSERT INTO `spbbase_district` VALUES ('dd', '张10', '', '', '1', '0', '0,', '150155', '0000150155', '0', '0', '张10', 'ddddd');
INSERT INTO `spbbase_district` VALUES ('ddd', '张9', '', '', '1', '0', '0,', '150155', '0000150155', '0', '0', '张9', 'ssssssss');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) unsigned NOT NULL,
  `login_name` varchar(20) NOT NULL COMMENT '登录名',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
