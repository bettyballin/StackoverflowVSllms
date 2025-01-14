ALTER TABLE `filesystem_data`.`$tablename`\n   ADD COLUMN `username` VARCHAR(100) AS (\n     SUBSTRING_INDEX(SUBSTRING_INDEX(`file_path`, '\\', 6), '\\', -1)\n   ) VIRTUAL;\n   \n   CREATE INDEX idx_username ON filesystem_data.$tablename (`username`);