SELECT COUNT(id) AS yearly_count\nFROM stats\nWHERE YEAR(record_date) = 2009\nGROUP BY YEAR(record_date);