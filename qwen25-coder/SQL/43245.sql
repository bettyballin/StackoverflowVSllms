CREATE PROCEDURE [dbo].[sp_Test1] /* 'b0da56dc-fc73-4c0e-85f7-541e3e8f249d' */\n(\n    @p_CreatedBy UNIQUEIDENTIFIER\n)\nAS\nDECLARE @sql NVARCHAR(4000)\n\nSET @sql = '\nSELECT \n  DateTime,\n  Subject,\n  CreatedBy\nFROM\n(\n  SELECT \n    DateTime, Subject, CreatedBy, \n    ROW_NUMBER() OVER(ORDER BY DateTime ) AS Indexing\n  FROM\n    ComposeMail\n  WHERE \n    CreatedBy = @p_CreatedBy /* <--- no need to declare here */\n) AS NewDataTable\n'\n\nEXEC sp_executesql @sql, N'@p_CreatedBy UNIQUEIDENTIFIER', @p_CreatedBy;