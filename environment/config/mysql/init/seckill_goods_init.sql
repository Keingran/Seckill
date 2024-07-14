create database if not exists seckill_goods default charset = utf8mb4;

use seckill_goods;

-- ----------------------------
-- Table structure for seckill_goods
-- ----------------------------
DROP TABLE IF EXISTS `seckill_goods`;
CREATE TABLE `seckill_goods`  (
  `id` bigint(20) NOT NULL COMMENT '商品id',
  `goods_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '商品名称',
  `activity_id` bigint(20) NULL DEFAULT 0 COMMENT '活动id',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `original_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '商品原价格',
  `activity_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '商品秒杀价格',
  `initial_stock` int(10) NULL DEFAULT 0 COMMENT '商品初始库存',
  `available_stock` int(10) NULL DEFAULT 0 COMMENT '商品当前可用库存',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '商品描述',
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '商品图片',
  `status` int(2) NULL DEFAULT 0 COMMENT '状态，0：已发布； 1：上线； 2：下线',
  `limit_num` int(11) NULL DEFAULT 1 COMMENT '限购个数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '秒杀商品表';
