SELECT *\nFROM ParentTable pt\nWHERE EXISTS (\n    SELECT 1\n    FROM SecondTable st\n    WHERE pt.Office_Code LIKE st.Code_Wildcard\n);