INSERT INTO `tbl` (`hat`, `mittens`, `name`)\nVALUES ('blue', 'green', 'betty')\nON DUPLICATE KEY UPDATE\n  `name` = IF(`name` <> VALUES(`name`), VALUES(`name`), `name`),\n  `last_update` = IF(`name` <> VALUES(`name`), CURRENT_TIMESTAMP, `last_update`);