SELECT GivenBy AS GivenBy_GivenTo,\n       [Alice],\n       [Bruce],\n       [Janet]\nFROM\n(\n    SELECT GivenBy, GivenTo, Points\n    FROM FeedbackSummary\n) AS SourceTable\nPIVOT\n(\n    MAX(Points)\n    FOR GivenTo IN ([Alice], [Bruce], [Janet])\n) AS PivotTable;