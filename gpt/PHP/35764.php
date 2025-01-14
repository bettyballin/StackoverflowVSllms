<?php\nrequire_once 'path/to/phptagengine.php'; // Include PHP Tag Engine\n\n// Initialize PHP Tag Engine\n$pte = new PHPTagEngine();\n\n// Function to display tag form for new items\nfunction displayNewTagForm() {\n    echo '<form method="post" action="save_tags.php">';\n    echo '<label for="tags">Tags:</label>';\n    echo '<input type="text" name="tags" id="tags" />';\n    echo '<input type="submit" value="Save Tags" />';\n    echo '</form>';\n}\n\n// Function to display tag form for existing items\nfunction displayExistingTagForm($item_id) {\n    global $pte;\n    echo $pte->html_item_tags($item_id);\n}\n\n// Check if item_id is set (indicating it's an existing item)\nif (isset($_GET['item_id']) && !empty($_GET['item_id'])) {\n    $item_id = intval($_GET['item_id']); // Sanitize input\n    displayExistingTagForm($item_id);\n} else {\n    displayNewTagForm();\n}\n?>