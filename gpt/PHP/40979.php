// Assuming the form array is submitted as 'items'\nif (isset($_POST['items'])) {\n    // Filter out null elements\n    $filteredItems = array_filter($_POST['items'], function($value) {\n        return !is_null($value);\n    });\n\n    // Store the filtered array into the session\n    $_SESSION['items'] = $filteredItems;\n}