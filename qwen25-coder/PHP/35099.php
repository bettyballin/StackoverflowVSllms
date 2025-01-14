$storeId = 32;\n$categorizedId = 33;\n$pathLikeParent = "4/{$categorizedId}/%";\n$pathLikeRootExceptSelf = '4/%/';\n$categoryIds = [4, 32];\n\n$query = "\n    SELECT * \n    FROM navigation \n    WHERE navigation_store_id = {$storeId} \n    AND (\n        navigation_category IN (".implode(', ', $categoryIds).") \n        OR navigation_path LIKE '{$pathLikeParent}%'\n        OR (navigation_path LIKE '{$pathLikeRootExceptSelf}' AND navigation_category <> {$categorizedId})\n    )\n    ORDER BY \n        CASE \n            WHEN navigation_category IN (".implode(', ', $categoryIds).") THEN 1\n            WHEN navigation_path LIKE '{$pathLikeParent}%' THEN 2\n            ELSE 3\n        END,\n        navigation_path;\n";\n\n// Execute the query with your database connection method and process the results.