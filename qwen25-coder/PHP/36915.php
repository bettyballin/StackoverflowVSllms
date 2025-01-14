// Assuming $dbh is a PDO instance already configured\n\n$columns = "name, address, city, state, zip";\n$sql = "INSERT INTO customer ($columns) VALUES (:name, :address, :city, :state, :zip)";\n$stmt = $dbh->prepare($sql);\n\n// Bind parameters to the prepared statement\n$stmt->bindParam(':name', $name);\n$stmt->bindParam(':address', $address);\n$stmt->bindParam(':city', $city);\n$stmt->bindParam(':state', $state);\n$stmt->bindParam(':zip', $zip);\n\n// Execute the statement\n$stmt->execute();