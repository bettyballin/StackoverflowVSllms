SELECT po.people_id\nFROM peoples_options po\nWHERE po.option_id IN (1, 34, 44, ...)\nGROUP BY po.people_id\nHAVING COUNT(DISTINCT po.option_id) = <number_of_options>;