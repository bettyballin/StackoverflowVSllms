insert parent (userId, group, name)\nselect distinct userId, group, concat("user ", userId, " - ", group, " data")\nfrom input_data;