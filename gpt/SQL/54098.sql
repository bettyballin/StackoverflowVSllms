CREATE FUNCTION [dbo].[GetRatingModifierInline]\n(\n    @ExamScore DECIMAL(6, 2),\n    @Project1Score DECIMAL(6, 2),\n    @Project2Score DECIMAL(6, 2),\n    @Project3Score DECIMAL(6, 2),\n    @SubjectTypeId TINYINT\n)\nRETURNS TABLE\nAS\nRETURN\n(\n    SELECT \n        (CASE @Project1Score\n            WHEN 1 THEN 10\n            WHEN 2 THEN 12.4\n            -- more cases\n        END +\n        CASE @Project2Score\n            -- cases for Project2Score\n        END +\n        CASE @Project3Score\n            -- cases for Project3Score\n        END) AS Score\n);