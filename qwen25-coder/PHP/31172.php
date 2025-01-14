$ratings = array(\n    1 => 1,\n    2 => 3,\n    3 => 6,\n    4 => 3,\n    5 => 3\n);\n\n$totalWeightedSum = 0;\n$totalCount = 0;\n\nforeach ($ratings as $rating => $weight) {\n    $totalWeightedSum += $rating * $weight;\n    $totalCount += $weight;\n}\n\nif ($totalCount > 0) {\n    $weightedMean = $totalWeightedSum / $totalCount;\n    echo "The weighted mean is: " . $weightedMean;\n} else {\n    echo "No ratings available.";\n}