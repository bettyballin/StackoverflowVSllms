$query = "SELECT * FROM my_table WHERE " . generateFilterCondition($userRoleId, 'my_table');