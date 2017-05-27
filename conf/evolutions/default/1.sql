# Mysql Schema creation

# --- !Ups

CREATE TABLE IF NOT EXISTS `task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text_col` TEXT NOT NULL,
  `creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `complete_date` DATETIME NULL,
  `completed` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));

# --- !Downs

DROP TABLE IF EXISTS `task` ;