MERGE INTO T_ELEMENT elt\nUSING (\n    SELECT ID_DEBTOR, HEADER\n    FROM T_DEBTOR\n    WHERE HEADER IS NOT NULL\n) debtor\nON (elt.ID_DEBTOR = debtor.ID_DEBTOR)\nWHEN MATCHED THEN\nUPDATE SET elt.INSURER = debtor.HEADER;