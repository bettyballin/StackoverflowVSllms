<?php\n\n// In your controller methods:\npublic function items() {\n    switch ($_SERVER['REQUEST_METHOD']) {\n        case 'GET':\n            // Fetch item or list of items\n            break;\n        case 'POST':\n            // Create a new item\n            break;\n        case 'PUT':\n            // Update an existing item\n            break;\n        case 'DELETE':\n            // Delete an item\n            break;\n    }\n}