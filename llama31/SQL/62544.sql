SELECT *\nFROM songs\nWHERE upload_date >= NOW() - INTERVAL 2 WEEK;