update t\nset EndTimeKey = DATE_NO\nfrom TableToUpdate t\nJoin Dates D on t.EndTime = d.DATE\nwhere EndTimeKey <> DATE_NO