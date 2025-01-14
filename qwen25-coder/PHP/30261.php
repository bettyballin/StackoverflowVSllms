// Ensure $_POST['game'] is set to prevent undefined index errors\nif (isset($_POST['game'])) {\n    $form = $_POST['game'];\n\n    // Print the array for debugging\n    print_r($form);\n\n    // Accessing System_ID using double quotes around the key, but it's not necessary\n    echo '#' . $form["System_ID"] . "#";\n\n    // Alternatively, use single quotes which is more common in PHP\n    echo '#' . $form['System_ID'] . "#";\n} else {\n    echo "POST data for 'game' is missing.";\n}