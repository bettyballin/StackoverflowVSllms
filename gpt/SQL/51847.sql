DELIMITER //\n\nCREATE PROCEDURE getUserById(IN userId INT)\nBEGIN\n    SELECT * FROM users WHERE id = userId;\nEND //\n\nDELIMITER ;