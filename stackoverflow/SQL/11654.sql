DECLARE @Random1 INT;\nDECLARE @Random2 INT;\nDECLARE @Random3 INT;\nDECLARE @Random4 INT;\nDECLARE @Random5 INT;\nDECLARE @Upper INT;\nDECLARE @Lower INT\n\n---- This will create a random number between 1 and count() of table\nSET @Lower = 1 ---- The lowest random number\nSELECT @Upper= COUNT(*) FROM Tbl_Organisations ---- The highest random number\nSELECT @Random1 = ROUND(((@Upper - @Lower -1) * RAND() + @Lower), 0)\nSELECT @Random2 = ROUND(((@Upper - @Lower -1) * RAND() + @Lower), 0)\nSELECT @Random3 = ROUND(((@Upper - @Lower -1) * RAND() + @Lower), 0)\nSELECT @Random4 = ROUND(((@Upper - @Lower -1) * RAND() + @Lower), 0)\nSELECT @Random5 = ROUND(((@Upper - @Lower -1) * RAND() + @Lower), 0)\n\nINSERT INTO Tbl_Campaigns (...., organisation_1,organisation_2,organisation_3...)\nSELECT\n    ...., t1.organisation_name, t2.organisation_name,t3.organisation_name...\n    FROM Tbl_Organisations            t1\n        INNER JOIN  Tbl_Organisations t2 ON t2.key=@Random2\n        INNER JOIN  Tbl_Organisations t3 ON t3.key=@Random3\n        INNER JOIN  Tbl_Organisations t4 ON t4.key=@Random4\n        INNER JOIN  Tbl_Organisations t5 ON t5.key=@Random5\n    WHERE t1.key=@Random1