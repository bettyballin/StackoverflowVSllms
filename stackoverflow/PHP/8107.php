$con = Propel::getConnection(DATABASE_NAME);\n\n$sql = "SELECT foobar.* FROM foobar WHERE created_at > DATE_SUB(curdate(), INTERVAL 1 MONTH)";  \n$stmt = $con->prepare($sql);\n$stmt->execute();\n\n$books = FoobarPeer::populateObjects($stmt);