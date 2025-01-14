$i = 0; // Initialize $i before starting the loop\n\nwhile ( $row = mysqli_fetch_assoc($results) ) { // Use mysqli_fetch_assoc directly for clarity\n    $cat[$i] = $row['category'];\n    $cat_id[$i] = $row['cat_id'];\n\n    echo '<li><input type="checkbox" name="' . htmlspecialchars($cat_id[$i]) . '"';\n\n    $isChecked = false; // Flag to determine if the checkbox should be checked\n    foreach ($link_cat as $linkCatId) { // Use a foreach loop for clarity and simplicity\n        if ($cat_id[$i] == $linkCatId) {\n            echo ' checked="checked"';\n            $isChecked = true;\n            break; // Exit the loop once a match is found to avoid unnecessary checks\n        }\n    }\n\n    echo '> ' . htmlspecialchars($cat[$i]) . '</li>';\n\n    $i++; // Increment $i after processing each row\n}