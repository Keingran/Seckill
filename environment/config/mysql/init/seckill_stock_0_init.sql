create database if not exists seckill_stock_0 default charset = utf8mb4;

use seckill_stock_0;

-- ----------------------------
-- Table structure for seckill_stock_bucket_0
-- ----------------------------
DROP TABLE IF EXISTS `seckill_stock_bucket_0`;
CREATE TABLE `seckill_stock_bucket_0`  (
  `id` bigint(20) NOT NULL COMMENT '库存分桶主键',
  `goods_id` bigint(20) NULL DEFAULT 0 COMMENT '商品id',
  `initial_stock` int(10) NULL DEFAULT 0 COMMENT '商品分桶初始库存',
  `available_stock` int(10) NULL DEFAULT 0 COMMENT '商品分桶当前可用库存',
  `status` int(2) NULL DEFAULT 0 COMMENT '状态，0: 不可用; 1:可用',
  `serial_no` int(11) NOT NULL COMMENT '库存分桶编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `seckill_bucket_goods_id_serial_no_uk`(`goods_id`, `serial_no`) USING BTREE,
  INDEX `seckill_bucket_goods_id_idx`(`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '秒杀商品库存分桶表';

-- ----------------------------
-- Table structure for seckill_stock_bucket_1
-- ----------------------------
DROP TABLE IF EXISTS `seckill_stock_bucket_1`;
CREATE TABLE `seckill_stock_bucket_1`  (
  `id` bigint(20) NOT NULL COMMENT '库存分桶主键',
  `goods_id` bigint(20) NULL DEFAULT 0 COMMENT '商品id',
  `initial_stock` int(10) NULL DEFAULT 0 COMMENT '商品分桶初始库存',
  `available_stock` int(10) NULL DEFAULT 0 COMMENT '商品分桶当前可用库存',
  `status` int(2) NULL DEFAULT 0 COMMENT '状态，0: 不可用; 1:可用',
  `serial_no` int(11) NOT NULL COMMENT '库存分桶编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `seckill_bucket_goods_id_serial_no_uk`(`goods_id`, `serial_no`) USING BTREE,
  INDEX `seckill_bucket_goods_id_idx`(`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '秒杀商品库存分桶表';

-- ----------------------------
-- Table structure for seckill_stock_bucket_2
-- ----------------------------
DROP TABLE IF EXISTS `seckill_stock_bucket_2`;
CREATE TABLE `seckill_stock_bucket_2`  (
  `id` bigint(20) NOT NULL COMMENT '库存分桶主键',
  `goods_id` bigint(20) NULL DEFAULT 0 COMMENT '商品id',
  `initial_stock` int(10) NULL DEFAULT 0 COMMENT '商品分桶初始库存',
  `available_stock` int(10) NULL DEFAULT 0 COMMENT '商品分桶当前可用库存',
  `status` int(2) NULL DEFAULT 0 COMMENT '状态，0: 不可用; 1:可用',
  `serial_no` int(11) NOT NULL COMMENT '库存分桶编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `seckill_bucket_goods_id_serial_no_uk`(`goods_id`, `serial_no`) USING BTREE,
  INDEX `seckill_bucket_goods_id_idx`(`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '秒杀商品库存分桶表';
