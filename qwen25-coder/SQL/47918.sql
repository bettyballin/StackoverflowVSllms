SELECT w.word FROM words w JOIN syns s ON w.defid = s.synsetid WHERE w.word LIKE '%happy%';