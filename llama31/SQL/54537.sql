SELECT \n    Index,\n    [A] AS A_Value,\n    [B] AS B_Value\nFROM \n    (SELECT \n         item,\n         val,\n         LEFT(item, 1) AS aspect,\n         RIGHT(item, 4) AS Index\n     FROM \n         (SELECT \n              A0001, A0002, A0003, B0001, B0002, B0003 \n          FROM \n              ptest \n          WHERE \n              timestamp > minv AND timestamp < maxv AND fn(timestamp) = fnv) p\n     UNPIVOT \n         (val FOR item IN (A0001, A0002, A0003, B0001, B0002, B0003)) AS unpvt) AS src\nPIVOT \n    (SUM(val) FOR aspect IN ([A], [B])) AS pvt