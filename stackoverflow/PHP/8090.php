$query = mysqli_query($db, "SELECT online FROM tbl_system WHERE property = 'extranet'");\n$row = mysqli_fetch_array($query);\n$online = $row[0];