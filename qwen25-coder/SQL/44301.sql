SELECT \n    date, \n    associate_id, \n    COUNT(*) as per_date\nFROM \n    tracking\nGROUP BY \n    date, \n    associate_id\nORDER BY \n    date, \n    associate_id;