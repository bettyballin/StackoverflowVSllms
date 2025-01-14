require_once 'patTemplate.php';\n\n$template = new patTemplate();\n\n// Define a pattern\n$template->readTemplatesFromInput('string:<table><tr><td>{CONTENT}</td></tr></table>');\n\n// Add some data to the template\n$template->addGlobalVar('CONTENT', 'Hello, World!');\n\n// Display the template\n$template->displayParsed();