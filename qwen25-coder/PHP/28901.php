if ($_POST['submit'] == "Next") {\n    $first = true; // Initialize a flag to track the first iteration\n    foreach($_POST['info'] as $key => $value) {\n        if ($first) {\n            $first = false; // Skip the first item\n            continue;\n        }\n        echo $value; // Process subsequent items\n    }\n}