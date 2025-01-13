CREATE OR REPLACE PROCEDURE get_data_type (dataType OUT VARCHAR2)\nAUTHID CURRENT_USER\nIS\nBEGIN\n    SELECT t.data_type INTO dataType \n    FROM dba_tab_cols t\n    WHERE t.table_name = 'ACCOUNTTYPE' \n      AND t.column_name = 'ACCESSEDBY';\nEND;\n/