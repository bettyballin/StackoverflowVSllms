SELECT *, SUM(...some SQL removed for brevity) AS Occurrences \nFROM some_table AS q\nWHERE criterion="value" \nGROUP BY q.P_id\nHAVING Occurrences > 0\nORDER BY Occurrences DESC \nLIMIT 10;