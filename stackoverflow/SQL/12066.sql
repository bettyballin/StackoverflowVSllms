SELECT  (\n        SELECT  avg(KW)\n        FROM    genset\n        WHERE   (GenSetName   like 'GEA3519')\n                and GenDate >= '1 jan   2003    00:00:00'\n                and GenDate < '1 feb 2003 00:00:00'\n        ) AS avg_GEA3519,\n        (\n        SELECT  avg(KW)\n        FROM    genset\n        WHERE   (GenSetName   like 'GEA3520')\n                and GenDate >= '1 jan   2003    00:00:00'\n                and GenDate < '1 feb 2003 00:00:00'\n        ) AS avg_GEA3520,\n        (\n        SELECT  avg(KW)\n        FROM    genset\n        WHERE   (GenSetName   like 'GEA3521')\n                and GenDate >= '1 jan   2003    00:00:00'\n                and GenDate < '1 feb 2003 00:00:00'\n        ) AS avg_GEA3521,\n        (\n        SELECT  avg(KW)\n        FROM    genset\n        WHERE   (GenSetName   like 'GEA3522')\n                and GenDate >= '1 jan   2003    00:00:00'\n                and GenDate < '1 feb 2003 00:00:00'\n        ) AS avg_GEA3522