SET @q = 'A,B';\n\nSELECT studentName\nFROM quizAnswers\nGROUP BY studentName\nHAVING\n        BIT_OR(1 << FIND_IN_SET(question, @q) - 1)\n    =\n        (1 << LENGTH(@q) - LENGTH(REPLACE(@q, ',', '')) + 1) - 1;