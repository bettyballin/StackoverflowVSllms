<?php\n// Example SQL query and loop\n$results = mysqli_query($connection, "SELECT id FROM table");\n$index = 0; // Initialize index\n\nwhile ($row = mysqli_fetch_assoc($results)) {\n    echo '<select name="vote_' . $index . '">';\n    echo '<option value="1">1</option>';\n    echo '<option value="2">2</option>';\n    echo '<option value="3">3</option>';\n    echo '</select>';\n\n    // Pass the index to JavaScript onclick function\n    echo '<input type="button" onclick="vote(' . $index . ')" value="Vote">';\n    \n    $index++; // Increment for next row\n}\n?>\n\n<script>\nfunction vote(index) {\n    // Access the selected value using the index\n    var selectedIndex = document.querySelector('select[name="vote_' + index + '"]').selectedIndex;\n    var selectedValue = document.querySelector('select[name="vote_' + index + '"]')\n        .options[selectedIndex].value;\n\n    console.log("Selected value for vote " + index + ": " + selectedValue);\n\n    // Add form submission or further processing here\n}\n</script>