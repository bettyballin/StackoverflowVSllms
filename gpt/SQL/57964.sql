ALTER TABLE master_table DROP COLUMN old_guid;\n    ALTER TABLE master_table CHANGE new_guid old_guid VARCHAR(36);\n    \n    ALTER TABLE child_table DROP COLUMN old_guid;\n    ALTER TABLE child_table CHANGE new_guid old_guid VARCHAR(36);