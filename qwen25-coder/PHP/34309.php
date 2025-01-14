$stmt = $pdo->prepare("\n  SELECT COUNT(DISTINCT a.id) AS total_companies\n  FROM `companies` a\n  JOIN `company_products` b ON b.company_id = a.id\n  JOIN `product_prices` c ON c.product_id = b.id\n  WHERE b.type = :type AND c.date = :date"\n);\n$stmt->execute([':type' => $productType, ':date' => $date]);\n$totalCompanies = $stmt->fetchColumn();