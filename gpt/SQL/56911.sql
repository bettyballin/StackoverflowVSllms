DELIMITER //\n\nCREATE TRIGGER after_update_trigger\nAFTER UPDATE ON your_table\nFOR EACH ROW\nBEGIN\n    CALL update_view();\nEND//\n\nDELIMITER ;