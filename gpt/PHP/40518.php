// In your view file (e.g., index.ctp)\nforeach ($items as $item) {\n    echo $item['Item']['name'];\n    if ($item['Item']['isOwnedByUser']) {\n        echo " - Owned by user";\n    } else {\n        echo " - Not owned by user";\n    }\n}