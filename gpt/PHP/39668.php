$results = array_merge($results, $new_days);\n$a = $results;\n\n// Extract unix_time values\n$unix_time = [];\nforeach ($results as $row) {\n    $unix_time[] = $row['unix_time'];\n}\n\n$b = $results;\n\n// Sort results by unix_time\narray_multisort($unix_time, SORT_ASC, $results);\n\n// Use array_column instead of a custom array_pluck function\n$days = implode('|', array_column($results, 'timestamp'));\n$views = implode('|', array_column($results, 'views'));\n$views_scaled = implode(',', array_column($results, 'views_scaled'));