SET @next_update_count = (SELECT IFNULL(MAX(UPDATE_COUNT), 0) + 1 FROM MYTABLE);\nINSERT INTO MYTABLE (NAME, STATUS, UPDATE_COUNT) VALUES ('John', 0, @next_update_count);