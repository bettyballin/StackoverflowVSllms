$stmt = $mysqli->prepare("INSERT INTO client_package (package_id, client_id, subaccount_id, ...) VALUES (?, ?, ?, ...)");\n$stmt->bind_param("siisss...", $package_id, $client_id, $subaccount_id, ...);\n$stmt->execute();