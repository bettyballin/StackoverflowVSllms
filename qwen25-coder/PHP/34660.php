// In your view file\n\nforeach ($items as $item) {\n    echo "<div>";\n    echo h($item['Item']['name']);\n    if (!empty($item['Item']['is_owned'])) {\n        echo " - You own this item!";\n    }\n    echo "</div>";\n}