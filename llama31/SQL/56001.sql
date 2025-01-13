SELECT TO_DATE(TRAIN.DEPARTURE_DATE,'YYYYMM')\n  , SUM(CASE WHEN PERSON_ID = '28' THEN 1 ELSE 0 END) AS Mark\n  , SUM(CASE WHEN PERSON_ID = '29' THEN 1 ELSE 0 END) AS Chris\nFROM TRAIN\nWHERE DEPARTURE_STATION = 'DUBLIN'\nGROUP BY DEPARTURE_DATE