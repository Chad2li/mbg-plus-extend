CREATE TABLE `emp`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `name`        varchar(10)         NOT NULL COMMENT 'user name',
    `age`         int(10) unsigned    NOT NULL COMMENT 'user age',
    `email`       varchar(64)                  DEFAULT NULL COMMENT 'user email',
    `create_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='employ';