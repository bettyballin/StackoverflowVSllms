SELECT \n  word,\n  MAX(ABS(big), ABS(expensive), ABS(smart), ABS(fast)) AS max_abs_value,\n  CASE \n    WHEN MAX(ABS(big), ABS(expensive), ABS(smart), ABS(fast)) = ABS(big) AND big < 0 THEN 'not big'\n    WHEN MAX(ABS(big), ABS(expensive), ABS(smart), ABS(fast)) = ABS(expensive) AND expensive < 0 THEN 'not expensive'\n    WHEN MAX(ABS(big), ABS(expensive), ABS(smart), ABS(fast)) = ABS(smart) AND smart < 0 THEN 'not smart'\n    WHEN MAX(ABS(big), ABS(expensive), ABS(smart), ABS(fast)) = ABS(fast) AND fast < 0 THEN 'not fast'\n    ELSE 'probably ' || \n      CASE \n        WHEN MAX(ABS(big), ABS(expensive), ABS(smart), ABS(fast)) = ABS(big) THEN 'big'\n        WHEN MAX(ABS(big), ABS(expensive), ABS(smart), ABS(fast)) = ABS(expensive) THEN 'expensive'\n        WHEN MAX(ABS(big), ABS(expensive), ABS(smart), ABS(fast)) = ABS(smart) THEN 'smart'\n        WHEN MAX(ABS(big), ABS(expensive), ABS(smart), ABS(fast)) = ABS(fast) THEN 'fast'\n      END\n  END AS description\nFROM your_table\nGROUP BY word