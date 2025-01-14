<?php\n// Assuming you have a function to fetch data from your database\nfunction getTextFromDatabase($divId) {\n    // Simulate fetching data from database based on div id\n    $data = [\n        'diva' => 'Updated text for Div A',\n        'divb' => 'Updated text for Div B'\n    ];\n    return isset($data[$divId]) ? $data[$divId] : 'Default Text';\n}\n\n// Check if button is clicked and get div id\n$selectedDivId = isset($_POST['update_div']) ? $_POST['update_div'] : null;\n$newText = $selectedDivId ? getTextFromDatabase($selectedDivId) : '';\n?>\n\n<!DOCTYPE html>\n<html lang="en">\n<head>\n    <meta charset="UTF-8">\n    <title>Dynamic Content Update</title>\n    <script>\n        function updateDivContent(divId, newText) {\n            document.getElementById(divId).innerText = newText;\n        }\n    </script>\n</head>\n<body>\n\n<div id="diva">this is div a</div>\n<div id="divb"> this is div b</div>\n\n<form method="post">\n    <label>\n        Select Div:\n        <select name="update_div" onchange="this.form.submit();">\n            <option value="">--Select--</option>\n            <option value="diva">Div A</option>\n            <option value="divb">Div B</option>\n        </select>\n    </label>\n    <button type="submit">Update Text</button>\n</form>\n\n<script>\n<?php if($newText): ?>\nupdateDivContent('<?php echo htmlspecialchars($selectedDivId, ENT_QUOTES, 'UTF-8'); ?>', '<?php echo htmlspecialchars($newText, ENT_QUOTES, 'UTF-8'); ?>');\n<?php endif; ?>\n</script>\n\n</body>\n</html>