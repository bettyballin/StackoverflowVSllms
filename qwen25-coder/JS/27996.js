// Create a select element\n$select = $("<select></select>");\n\n// Function to add options with key-value pairs\n$select.addOption = function(key, value) {\n    $(this).append(\n        $("<option/>")\n            .text(value)\n            .val(key) // Set the value attribute (can be different from the key if necessary)\n            .data('key', key) // Store the key in a data attribute\n    );\n};\n\n// Append options with keys and values\n$select.addOption(1, "Jason")\n       .addOption(32, "John")\n       .addOption(423, "Paul");\n\n// Retrieving an option's value and custom key based on its text or other criteria\nvar selectedValue = $select.find(':selected').text(); // Get the selected option's text\nvar selectedKey = $select.find(':selected').data('key'); // Retrieve the associated key\n\nconsole.log("Selected Option Text: " + selectedValue);\nconsole.log("Associated Key: " + selectedKey);