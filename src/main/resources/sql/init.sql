CREATE DATABASE `lijingjing` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

CREATE TABLE `lijingjing`.`user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uk_username`(`username`) USING BTREE
);

INSERT INTO `lijingjing`.`user`(`username`, `password`) VALUES ('123', '202cb962ac59075b964b07152d234b70');
INSERT INTO `lijingjing`.`user`(`username`, `password`) VALUES ('lijingjing', '2e602c523579aba9ece06e36f0e12c12');
