CREATE FUNCTION [dbo].[GetRatingModifier]\n(\n    @ExamScore DECIMAL(6, 2),\n    @Project1Score DECIMAL(6, 2),\n    @Project2Score DECIMAL(6, 2),\n    @Project3Score DECIMAL(6, 2),\n    @SubjectTypeId TINYINT\n)\nRETURNS DECIMAL(8, 5)\nWITH INLINE = ON\nAS\nBEGIN\n    RETURN (\n        CASE @Project1Score\n            WHEN 1 THEN 10\n            WHEN 2 THEN 12.4\n            ...\n        END +\n        CASE @Project2Score\n            ...\n        END +\n        ...\n    );\nEND;