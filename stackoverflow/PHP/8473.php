$query = "SELECT volunteers_2009.id, volunteers_2009.comments, volunteers_2009.choice1, volunteers_2009.choice2, volunteers_2009.choice3, volunteers_2009.lname, volunteers_2009.fname, volunteers_2009.venue_id, venues.venue_name FROM volunteers_2009 AS volunteers_2009 LEFT OUTER JOIN venues ON (volunteers_2009.venue_id = venues.id) ORDER by $order $sort";\n\n$res = mysql_query($query);\necho "<select name = 'venue'>";\nwhile (($row = mysql_fetch_row($res)) != null)\n{\n    echo "<option value = '{$row['venue_id']}'";\n    if ($selected_venue_id == $row['venue_id'])\n        echo "selected = 'selected'";\n    echo ">{$row['venue_name']}</option>";\n}\necho "</select>";