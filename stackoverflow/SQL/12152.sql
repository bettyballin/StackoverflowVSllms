CREATE TABLE #t (startz INT, zend INT)\ninsert into #t (startz, zend) values (1,5)\ninsert into #t (startz, zend) values (6,11)\ninsert into #t (startz, zend) values (12,18)\ninsert into #t (startz, zend) values (25,31)\ninsert into #t (startz, zend) values (32,43)\n\nselect * from #t ta\nLEFT OUTER JOIN #t tb ON tb.startz - 1 = ta.zend\nWHERE tb.startz IS NULL