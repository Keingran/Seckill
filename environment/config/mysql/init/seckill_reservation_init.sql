create database if not exists seckill_reservation default charset = utf8mb4;

use seckill_reservation;

-- ----------------------------
-- Table structure for seckill_reservation_config
-- ----------------------------
DROP TABLE IF EXISTS `seckill_reservation_config`;
CREATE TABLE `seckill_reservation_config`  (
   `id` bigint(20) NOT NULL COMMENT '数据主键',
   `goods_id` bigint(20) NULL DEFAULT 0 COMMENT '商品id',
   `goods_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '商品名称',
   `reserve_max_user_count` int(11) NULL DEFAULT 0 COMMENT '预约人数上限，不做严格限制',
   `reserve_current_user_count` int(11) NULL DEFAULT 0 COMMENT '当前预约人数，实际可比预约人数上限大，也可比其小，在一定范围内即可',
   `reserve_start_time` datetime(0) NULL DEFAULT NULL COMMENT '预约开始时间',
   `reserve_end_time` datetime(0) NULL DEFAULT NULL COMMENT '预约结束时间',
   `seckill_start_time` datetime(0) NULL DEFAULT NULL COMMENT '秒杀开始时间',
   `seckill_end_time` datetime(0) NULL DEFAULT NULL COMMENT '秒杀结束时间',
   `status` int(2) NULL DEFAULT 1 COMMENT '状态，0：已发布，1：上线；-1：下线',
   PRIMARY KEY (`id`) USING BTREE,
   UNIQUE INDEX `goods_id_index`(`goods_id`) USING BTREE COMMENT '一个秒杀商品存在一条预约规则信息'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '针对商品配置的预约配置表';

-- ----------------------------
-- Records of seckill_reservation_config
-- ----------------------------

-- ----------------------------
-- Table structure for seckill_reservation_user
-- ----------------------------
DROP TABLE IF EXISTS `seckill_reservation_user`;
CREATE TABLE `seckill_reservation_user`  (
 `id` bigint(20) NOT NULL COMMENT '数据主键',
 `reserve_config_id` bigint(20) NULL DEFAULT 0 COMMENT '预约配置id',
 `goods_id` bigint(20) NULL DEFAULT 0 COMMENT '商品id',
 `goods_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '商品名称',
 `user_id` bigint(20) NULL DEFAULT 0 COMMENT '用户id',
 `reserve_time` datetime(0) NULL DEFAULT NULL COMMENT '预约时间',
 `status` int(2) NULL DEFAULT 1 COMMENT '状态，1：正常；0：删除',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `user_id_index`(`user_id`) USING BTREE COMMENT '用户id索引',
 INDEX `goods_id_index`(`goods_id`) USING BTREE COMMENT '商品id索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户预约商品的记录表';

-- ----------------------------
-- Records of seckill_reservation_user
-- ----------------------------
