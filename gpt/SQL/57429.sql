ALTER TABLE `filesystem_data`.`$tablename`\nPARTITION BY HASH(file_share_name)\nPARTITIONS 10;