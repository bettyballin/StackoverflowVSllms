function get_total_adults() {\n    $sql = 'SELECT SUM(number_adults_attending) FROM is_nfo_rsvp';\n    $result = mysql_query($sql) or die(mysql_error());\n    // I'd throw a catchable exception (see below) rather than die with a MySQl error\n\n    return mysql_result($result, 0);\n}