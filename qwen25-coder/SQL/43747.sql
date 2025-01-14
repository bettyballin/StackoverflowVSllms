SELECT \n    LastAccessed = ISNULL(CONVERT(varchar, (SELECT MAX(modifydate) FROM scormtrackings WHERE bundleid=@bundleid AND userid=u.userid), 120), ''),\n    CompletedLessons = ISNULL((SELECT Value FROM scormtrackings WHERE bundleid=@bundleid AND userid=u.userid AND param='vegas2.progress'), ''),\n    TotalLessons = 100,\n    TotalNumAvail = 100,\n    TotalNumCorrect = ISNULL((SELECT Value FROM scormtrackings WHERE bundleid=@bundleid AND userid=u.userid AND param='cmi.score.raw'), '')