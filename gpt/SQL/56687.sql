CREATE FUNCTION MaraSizeCaseExample\n(\n    @ms varchar(10)\n)\nRETURNS varchar(10)\nAS\nBEGIN\n    DECLARE @result varchar(10);\n\n    SET @result = CASE \n        WHEN @ms = '16-18' THEN '1'\n        WHEN @ms = '18-20' THEN '2'\n        WHEN @ms = '20-22' THEN '3'\n        WHEN @ms = '22+' THEN '4'\n        WHEN @ms = '24+' THEN '5'\n        WHEN @ms = '14-16' THEN '7'\n        ELSE 'BAD'\n    END;\n\n    RETURN @result;\nEND;\nGO