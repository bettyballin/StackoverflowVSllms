SELECT userid\nFROM UserRole\nWHERE roleid IN (1, 2, 3)\nGROUP BY userid\nHAVING COUNT(DISTINCT roleid) = 3;