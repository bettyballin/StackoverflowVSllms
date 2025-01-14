CREATE PROCEDURE SearchClients\n    @LastName VARCHAR(50) = NULL,\n    @FirstName VARCHAR(50) = NULL,\n    @MiddleName VARCHAR(50) = NULL,\n    @DOB DATETIME = NULL,\n    @HomePhone VARCHAR(10) = NULL,\n    @WorkPhone VARCHAR(10) = NULL\nAS\nBEGIN\n    SELECT Last_Name, First_Name, Mid_Name, DOB, Home_Phone, Work_Phone \n    FROM dbo.tblClient\n    WHERE (@LastName IS NULL OR Last_Name LIKE '%' + @LastName + '%')\n      AND (@FirstName IS NULL OR First_Name LIKE '%' + @FirstName + '%')\n      AND (@MiddleName IS NULL OR Mid_Name LIKE '%' + @MiddleName + '%')\n      AND (@DOB IS NULL OR DOB = CAST(@DOB AS DATETIME))\n      AND (@HomePhone IS NULL OR Home_Phone LIKE '%' + @HomePhone + '%')\n      AND (@WorkPhone IS NULL OR Work_Phone LIKE '%' + @WorkPhone + '%');\nEND;