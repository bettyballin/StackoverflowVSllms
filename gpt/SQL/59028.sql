DELIMITER //\n\nCREATE PROCEDURE normalize_table()\nBEGIN\n    -- Insert unique data into the new table\n    INSERT INTO new_table (column1, column2)\n    SELECT DISTINCT column1, column2\n    FROM your_huge_table;\n\n    -- Update original table to reference new table\n    UPDATE your_huge_table yt\n    JOIN new_table nt ON yt.column1 = nt.column1 AND yt.column2 = nt.column2\n    SET yt.new_table_id = nt.id;\n    \n    -- Further operations to remove the original columns if needed\n    ALTER TABLE your_huge_table DROP COLUMN column1, DROP COLUMN column2;\nEND //\n\nDELIMITER ;