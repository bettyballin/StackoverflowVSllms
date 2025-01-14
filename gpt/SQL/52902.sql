SET ANSI_NULLS ON\nSET QUOTED_IDENTIFIER ON\nGO\n\nALTER PROCEDURE [dbo].[GetUserDetailsByUserID]\n(\n    @UserId VARCHAR(100)\n)\nAS\nBEGIN\n    IF EXISTS(SELECT 1 FROM Registration WHERE UserId = @UserId)\n    BEGIN\n        SELECT\n               [Name],\n               [UserId],\n               [PermanentAddress],\n               [TemporaryAddress],\n               [OfficePhoneNo],\n               [ResidentialPhoneNo],\n               [MobileNo],\n               [Email],\n               [ContactPerson],\n               [C_OfficePhoneNo],\n               [C_ResidentialPhoneNo],\n               [C_MobileNo],\n               [C_Email],\n               [Project],\n               [TotalAmount]\n        FROM\n            Registration\n        WHERE\n            UserId = @UserId\n    END\n    ELSE\n    BEGIN\n        -- Return an empty result set with the same structure\n        SELECT\n               CAST(NULL AS VARCHAR(100)) AS [Name],\n               CAST(NULL AS VARCHAR(100)) AS [UserId],\n               CAST(NULL AS VARCHAR(255)) AS [PermanentAddress],\n               CAST(NULL AS VARCHAR(255)) AS [TemporaryAddress],\n               CAST(NULL AS VARCHAR(20)) AS [OfficePhoneNo],\n               CAST(NULL AS VARCHAR(20)) AS [ResidentialPhoneNo],\n               CAST(NULL AS VARCHAR(20)) AS [MobileNo],\n               CAST(NULL AS VARCHAR(100)) AS [Email],\n               CAST(NULL AS VARCHAR(100)) AS [ContactPerson],\n               CAST(NULL AS VARCHAR(20)) AS [C_OfficePhoneNo],\n               CAST(NULL AS VARCHAR(20)) AS [C_ResidentialPhoneNo],\n               CAST(NULL AS VARCHAR(20)) AS [C_MobileNo],\n               CAST(NULL AS VARCHAR(100)) AS [C_Email],\n               CAST(NULL AS VARCHAR(100)) AS [Project],\n               CAST(NULL AS DECIMAL(18, 2)) AS [TotalAmount]\n        WHERE 1 = 0 -- This ensures no rows are returned\n    END\nEND