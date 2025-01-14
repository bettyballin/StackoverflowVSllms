WITH SequencedData AS (\n    SELECT \n        id,\n        Date, \n        Letter,\n        CASE \n            WHEN ASCII(Letter) = 90 THEN 86 -- 'Z' to virtual 'A'\n            ELSE ASCII(Letter)\n        END AS ascii_letter,\n        ROW_NUMBER() OVER (PARTITION BY Date ORDER BY id) as rn\n    FROM TABLE1\n),\nNextInSequence AS (\n    SELECT \n        sds.id, \n        sds.Date, \n        sds.letter, \n        CASE \n            WHEN ASCII(sdns.Letter) = 65 THEN 90 -- 'A' to virtual 'Z'\n            ELSE ASCII(sdns.Letter)\n        END AS ascii_next_letter\n    FROM SequencedData sds\n    LEFT JOIN SequencedData sdns ON sds.Date = sdns.Date AND sds.rn + 1 = sdns.rn\n)\n\nSELECT \n    n.id, \n    n.Date, \n    n.letter\nFROM NextInSequence n\nWHERE (n.ascii_letter + 1) % 90 != n.ascii_next_letter;