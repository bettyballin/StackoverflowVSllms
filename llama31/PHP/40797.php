<?php\n$dt = new DateTime('now');\n$months = array();\n\nfor ($i = 0; $i < 12; $i++) {\n    $month = $dt->format('F');\n    $months[] = $month;\n    $dt->modify('+1 month');\n}\n\n// Get the current month\n$currentMonth = date('F');\n\n// Move the current month to the top of the list\n$months = array_merge(array($currentMonth), array_diff($months, array($currentMonth)));\n\nforeach ($months as $month) {\n    echo '<a href="http://mydomain.com/' . strtolower($month) . '/" title="' . $month . '">' . $month . '</a><br />';\n}