SELECT ... INTO #TempT1 FROM ...;\n   SELECT ... INTO #TempT2 FROM ...;\n\n   SELECT ...\n   FROM #TempT1 T1\n   JOIN #TempT2 T2 ON ...\n   GROUP BY ...;