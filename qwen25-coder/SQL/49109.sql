DELIMITER //\n\nCREATE PROCEDURE GetEmployeeDetails(IN empID INT)\nBEGIN\n    SELECT * FROM employees WHERE id = empID;\nEND //\n\nDELIMITER ;