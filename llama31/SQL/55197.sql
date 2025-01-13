SELECT startTime, endTime,\n       cast(datediff(mi, starttime, endtime) / 60 as varchar)\n       +':'+\n       cast(datediff(mi, starttime, endtime) % 60 as varchar) AS RUNTIME\nFROM applog\nWHERE runID = 33871\nORDER BY startTime DESC