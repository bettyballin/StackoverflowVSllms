$array = [ /* ... your array data here as shown above ... */ ];\n\n// Outer loop for each category\nforeach ($array as $categoryData) {\n    // Accessing the Category details\n    echo "Category Name: " . htmlspecialchars($categoryData['Category']['name']) . "<br>";\n\n    // Inner loop for each forum within the current category\n    foreach ($categoryData['Forum'] as $forumData) {\n        // Accessing the Forum details\n        echo "  Forum Name: " . htmlspecialchars($forumData['name']) . "<br>";\n        echo "  Forum Description: " . htmlspecialchars($forumData['description']) . "<br>";\n        // Add more fields as needed\n    }\n}