SELECT SCN, \n       TIMESTAMP \n  FROM SMON_SCN_TIME \n WHERE SCN BETWEEN :start_scn AND :end_scn;