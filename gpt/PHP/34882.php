$region_id = intval($_GET['region_id']); // Ensure to sanitize input\n$query = "EXPLAIN SELECT * FROM your_table WHERE region_id = $region_id";\n$result = mysqli_query($connection, $query);\n$row = mysqli_fetch_assoc($result);\n$approximate_count = $row['rows'];