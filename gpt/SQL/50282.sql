DECLARE @checkvar VARCHAR(10)\nDECLARE @tbl TABLE (colx VARCHAR(10))\n\nSET @checkvar = 'a'\n\nINSERT INTO @tbl (colx) VALUES ('a')\nINSERT INTO @tbl (colx) VALUES ('b')\nINSERT INTO @tbl (colx) VALUES ('c')\nINSERT INTO @tbl (colx) VALUES ('d')\n\n-- Create the temp table structure first\nCREATE TABLE #temp1 (colx VARCHAR(10))\n\n-- Insert data into the temp table based on the condition\nIF @checkvar IS NULL\nBEGIN\n    INSERT INTO #temp1 (colx)\n    SELECT colx FROM @tbl\nEND\nELSE\nBEGIN\n    INSERT INTO #temp1 (colx)\n    SELECT colx FROM @tbl WHERE colx = @checkvar\nEND\n\n-- Verify the result\nSELECT * FROM #temp1\n\n-- Drop the temp table\nDROP TABLE #temp1