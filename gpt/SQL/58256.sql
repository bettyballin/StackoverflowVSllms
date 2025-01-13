SELECT T.tabname AS table_name, I.idxname AS index_name\nFROM sysindexes I\nJOIN systables T ON I.tabid = T.tabid\nWHERE T.tabname IN (\n    SELECT DISTINCT B.tabname\n    FROM sysviews A\n    JOIN systables B ON A.viewtext LIKE '%' || B.tabname || '%'\n    WHERE A.tabname = 'your_view_name'\n);