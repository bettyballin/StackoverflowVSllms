$ids = join("','",$galleries);   \n$sql = "SELECT * FROM galleries WHERE id IN ('$ids')";