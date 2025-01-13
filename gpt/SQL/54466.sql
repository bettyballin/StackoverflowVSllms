SELECT *\n   FROM (\n       SELECT Year, Quarter, Revenue\n       FROM Sales\n   ) AS SourceTable\n   PIVOT (\n       SUM(Revenue)\n       FOR Quarter IN ([Q1], [Q2], [Q3], [Q4])\n   ) AS PivotTable;