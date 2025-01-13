SELECT MIN(uid) as uid, key, email\nFROM Keys k INNER JOIN \n    (SELECT email FROM KEYS GROUP by email HAVING COUNT(email) > 1 ) k2\n    ON k.email = k2.email\nGROUP BY key, email\nHAVING COUNT(key) = 1