// Assume $records is an array containing data retrieved from the database.\n$records = [\n    ['id' => 1, 'name' => 'Record 1'],\n    ['id' => 2, 'name' => 'Record 2'],\n    // more records...\n];\n\necho '<form method="post" action="">\n        <table border="1">\n            <tr>\n                <th>Select</th>\n                <th>Name</th>\n            </tr>';\n\nforeach ($records as $record) {\n    echo "<tr>";\n    echo "<td><input type='checkbox' name='selected_ids[]' value='" . htmlspecialchars($record['id']) . "'></td>";\n    echo "<td>" . htmlspecialchars($record['name']) . "</td>";\n    echo "</tr>";\n}\n\necho '</table>\n      <button type="submit">Submit</button>\n      </form>';\n\n// Handling form submit\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    if (!empty($_POST['selected_ids'])) {\n        $selectedIds = $_POST['selected_ids'];\n        foreach ($selectedIds as $id) {\n            // Sanitize the ID\n            $safeId = filter_var($id, FILTER_SANITIZE_NUMBER_INT);\n            echo "Checkbox for record with ID $safeId is checked.<br>";\n            // Proceed with further actions like deleting/updating records based on $safeId\n        }\n    } else {\n        echo 'No checkboxes were selected.';\n    }\n}