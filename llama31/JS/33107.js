// Assume you have a single Filtered Text Box Extender with ID "ftbe"\n// and multiple text boxes with IDs "textBox1", "textBox2", etc.\n\n// Define a function to reassign the TargetControl property\nfunction reassignFtbe(textBoxId) {\n  $find("ftbe").set_TargetControlId(textBoxId);\n}\n\n// Call the function on blur event of each text box\ntextBox1.onblur = function() { reassignFtbe("textBox1"); };\ntextBox2.onblur = function() { reassignFtbe("textBox2"); };\n// ...