<?php\n// Check if the search term is provided via POST or GET\n$searchTerm = isset($_POST['search']) ? $_POST['search'] : (isset($_GET['search']) ? $_GET['search'] : '');\n\nif ($searchTerm) {\n    // Perform your search logic here\n    echo "Searching for: " . htmlspecialchars($searchTerm);\n} else {\n    echo "No search term provided.";\n}\n?>