SELECT e2.id\nFROM mm_eventlist_dates e1\njoin mm_eventlist_dates e2 on e2.startdate = date_add(e1.enddate, INTERVAL 1 DAY)\nwhere e1.id=$id