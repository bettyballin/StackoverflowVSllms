INSERT INTO MYTABLE\nSELECT NEW_ID AS ID, t.*\nFROM (\n  SELECT *, NULL AS ID FROM MYTABLE\n) t;