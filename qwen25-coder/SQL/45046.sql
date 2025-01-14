SELECT [ShortWebID], [AvgSpeed], [update_time], [WebName] \nFROM [vwAverageSpeed]\nWHERE (([WebName] LIKE '%' + @WebName + '%') AND ([update_time] > @update_time))\nORDER BY CASE \n          WHEN [WebName] LIKE '%EB%' THEN [Longitude]\n          WHEN [WebName] LIKE '%WB%' THEN [Longitude]\n          WHEN [WebName] LIKE '%NB%' THEN [Latitude]\n          WHEN [WebName] LIKE '%SB%' THEN [Latitude]\n         END