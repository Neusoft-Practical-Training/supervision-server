CREATE TABLE IF NOT EXISTS `users` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `user_id` INTEGER NOT NULL COMMENT '自增主键',
    `login_code` VARCHAR(255) NOT NULL COMMENT '对于公众监督员使用其手机号，其余用户尽量使用其手机号，若冲突，再做一定处理',
    `password` VARCHAR(255) NOT NULL COMMENT '6-16位',
    `tel` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL COMMENT '用户真实姓名',
    `gender` ENUM('0', '1', '2') NOT NULL DEFAULT '0' COMMENT '枚举（默认为0:未知，1:男，2:女）',
    `role` ENUM('0', '1', '2') NOT NULL COMMENT '枚举（0:管理员，2:公众监督员，3:网格员）',
    `age` INTEGER NOT NULL,
    `remarks` VARCHAR(255) COMMENT '非必需',
    `status` JSON NOT NULL COMMENT '布尔（0：不可用，默认为1：可用）',
    `avatar` VARCHAR(255) NOT NULL COMMENT 'base64格式',
    `create_time` VARCHAR(255) NOT NULL,
    `update_time` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `admins` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `user_id` INTEGER NOT NULL COMMENT '主键&外键：users/user_id',
    `province_id` VARCHAR(255) NOT NULL COMMENT '外键：provinces/province_id',
    `city_id` VARCHAR(255) NOT NULL COMMENT '外键：cities/city_id',
    `permission` ENUM('0', '1', '2') NOT NULL COMMENT '枚举（0:全国，1:省级，2：市级）',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `grimMembers` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `user_id` INTEGER NOT NULL COMMENT '主键&外键：users/user_id',
    `province_id` VARCHAR(255) NOT NULL COMMENT '外键：provinces/province_id',
    `city_id` VARCHAR(255) NOT NULL COMMENT '外键：cities/city_id',
    `state` ENUM('0', '1', '2', '3', '4', '5') NOT NULL COMMENT '枚举（0:空闲，1:工作中，2:临时抽调，3:休假，4：待审核，5:其他）',
    `task_num` INTEGER NOT NULL COMMENT '待完成任务数量',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `aqi` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `aqi_id` ENUM('0', '1', '2', '3', '4', '5') NOT NULL DEFAULT '0' COMMENT '主键：空气质量指数级别（共六级：0：优，1:良，2：轻度污染，3:中度污染，4:重度污染，5:严重污染）',
    `chinese_explain` VARCHAR(255) NOT NULL COMMENT '空气质量指数级别汉字表述',
    `aqi_explain` VARCHAR(255) NOT NULL COMMENT '空气质量指数具体说明',
    `color` VARCHAR(255) NOT NULL COMMENT '空气质量指数表示颜色（RGB）',
    `health_impact` VARCHAR(255) NOT NULL COMMENT '本等级空气质量指数对健康的影响',
    `suggestions` VARCHAR(255) NOT NULL COMMENT '建议采纳的措施',
    `so2_min` DOUBLE PRECISION NOT NULL COMMENT '本级别二氧化硫浓度最小值',
    `so2_max` DOUBLE PRECISION NOT NULL COMMENT '本级别二氧化硫浓度最大值',
    `co_min` DOUBLE PRECISION NOT NULL COMMENT '本级别一氧化碳浓度最小值',
    `co_max` DOUBLE PRECISION NOT NULL COMMENT '本级别一氧化碳浓度最大值',
    `spm_min` DOUBLE PRECISION NOT NULL COMMENT '本级别悬浮颗粒物浓度最小值',
    `spm_max` DOUBLE PRECISION NOT NULL COMMENT '本级别悬浮颗粒物浓度最大值',
    `remarks` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `apiFeedback` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `af_id` INTEGER NOT NULL COMMENT '自增主键',
    `supervisor_id` INTEGER NOT NULL COMMENT '外键：users/user_id',
    `grid_id` VARCHAR(255) NOT NULL COMMENT '外键：grids/grid_id',
    `address` VARCHAR(255) NOT NULL,
    `pre_aqi_id` INTEGER NOT NULL COMMENT '外键：aqi/aqi_id',
    `explain` VARCHAR(255) COMMENT '非必需',
    `af_date` VARCHAR(255) NOT NULL,
    `af_time` VARCHAR(255) NOT NULL,
    `state` ENUM('0', '1', '2') NOT NULL COMMENT '枚举（默认为0:未指派，1:已指派，2:已确认）',
    `aa_id` INTEGER NOT NULL COMMENT '外键：aqi_assignment/aa_id',
    `remarks` VARCHAR(255) COMMENT '非必需',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `aqiStatistics` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `as_id` INTEGER NOT NULL COMMENT '自增主键',
    `aa_id` INTEGER NOT NULL COMMENT '外键：aqi_assignment/aa_id',
    `gm_id` INTEGER NOT NULL COMMENT '外键：users/user_id',
    `grid_id` VARCHAR(255) NOT NULL COMMENT '外键：grids/grid_id',
    `address` VARCHAR(255) NOT NULL COMMENT '反馈信息所在区域详细地址',
    `confirm_aqi_id` INTEGER NOT NULL COMMENT '外键：aqi/aqi_id',
    `confirm_date` VARCHAR(255) NOT NULL,
    `confirm_time` VARCHAR(255) NOT NULL,
    `so2_value` DOUBLE PRECISION NOT NULL COMMENT '二氧化硫浓度',
    `so2_level` INTEGER NOT NULL COMMENT '二氧化硫级别',
    `co_value` DOUBLE PRECISION NOT NULL COMMENT '一氧化碳浓度',
    `co_level` INTEGER NOT NULL COMMENT '一氧化碳级别',
    `spm_value` DOUBLE PRECISION NOT NULL COMMENT '空气悬浮颗粒物浓度',
    `spm_level` INTEGER NOT NULL COMMENT '空气悬浮颗粒物级别',
    `remarks` VARCHAR(255) COMMENT '非必需',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `aqiAssignment` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `aa_id` INTEGER NOT NULL COMMENT '自增主键',
    `af_id` INTEGER NOT NULL COMMENT '外键：aqi_feedback/af_id',
    `as_id` INTEGER NOT NULL COMMENT '外键：aqi_statistics/as_id',
    `admin_id` INTEGER NOT NULL COMMENT '外键：users/user_id',
    `supervisor_id` INTEGER NOT NULL COMMENT '外键：users/user_id',
    `gm_id` INTEGER NOT NULL COMMENT '外键：users/user_id（如果跨域，则由对方区域管理员指定网格员）',
    `grid_id` VARCHAR(255) NOT NULL COMMENT '外键：grids/grid_id',
    `address` VARCHAR(255) NOT NULL,
    `assign_date` VARCHAR(255) NOT NULL,
    `assign_time` VARCHAR(255) NOT NULL,
    `cross_domain` JSON NOT NULL COMMENT '布尔类型（默认为0:未跨域，1:跨域）',
    `completed` ENUM('0', '1', '2', '3', '4', '5') NOT NULL COMMENT '枚举（默认为0：未完成，1：已完成，2：跨域请求中，3：跨域请求拒绝，4：跨域已受理，5：跨域任务完成）',
    `remarks` VARCHAR(255) COMMENT '非必需',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

