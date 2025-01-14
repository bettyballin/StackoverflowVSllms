DECLARE @the_date DATETIME\nDECLARE @date_string VARCHAR(15) = '31-DEC-2020' -- Example date string input\n\nIF EXISTS (\n    SELECT 1 \n    FROM (SELECT DATEFORMAT(ymd, @date_string) AS dt) AS temp \n    WHERE temp.dt IS NOT NULL AND @date_string LIKE '__-___-____'\n)\nBEGIN\n    SET @the_date = CONVERT(DATETIME, @date_string, 105) -- style 105 corresponds to dd-mon-yyyy\nEND\nELSE\nBEGIN\n    SET @the_date = GETDATE()\nEND\n\nSELECT @the_date AS ResultingDate