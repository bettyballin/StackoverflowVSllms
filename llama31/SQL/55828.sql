SELECT * FROM RecentRecordSum WHERE OffsetDate = (SELECT OffsetDate FROM GetDateOffset(-14))