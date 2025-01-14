INSERT IGNORE INTO test (RECNUM, ORDERNUM, CREATEDATE, EXPIREDATE, FNAME, LNAME)\nSELECT \n    RECNUM, \n    ORDERNUM, \n    CREATEDATE,\n    CASE \n        WHEN STR_TO_DATE(CONCAT(expiredate, ' ', YEAR(NOW())), '%b %d %Y') IS NOT NULL THEN\n            CAST(\n                CASE \n                    WHEN STR_TO_DATE(CONCAT(expiredate, ' ', YEAR(NOW())), '%b %d %Y') <= CURDATE() \n                        THEN STR_TO_DATE(CONCAT(expiredate, ' ', 1+YEAR(NOW())), '%b %d %Y')\n                    ELSE STR_TO_DATE(CONCAT(expiredate, ' ', YEAR(NOW())), '%b %d %Y')\n                END AS DATETIME\n            )\n        ELSE NULL -- This handles rows where date conversion fails\n    END AS EXPIREDATE,\n    FNAME, \n    LNAME \nFROM test_tmp;