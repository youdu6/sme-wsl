CREATE TABLE IF NOT EXISTS `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS people(
    persion_id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    PRIMARY KEY (persion_id)
);