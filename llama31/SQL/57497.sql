ALTER VIEW [dbo].[v_users]\nAS\nSELECT \n    RIGHT('000000000' + CONVERT(VARCHAR(9), user_id), 9) AS auid, \n    user_id, \n    username\nFROM dbo.users;