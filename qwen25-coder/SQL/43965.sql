INSERT INTO tableA (userid, courseid)\nSELECT userid, courseid\nFROM tableB\nWHERE courseid = 11;