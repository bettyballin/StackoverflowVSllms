function addNewMember() {\n    $query = "INSERT INTO members (/* other columns */) VALUES (/* corresponding values */)";\n    mysql_query($query) or showError("Unable to add new member");\n    return mysql_insert_id(); // Get the last inserted ID\n}