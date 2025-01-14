<?php\n\n// Sample function to get data from database\nclass School {\n    public function get($key) {\n        // Simulate database call\n        $data = [\n            'studentCount' => 300,\n            'teacherCount' => 20,\n            'className' => 'Grade 10'\n        ];\n        return isset($data[$key]) ? $data[$key] : null;\n    }\n}\n\n$school = new School();\n\n// Sample HTML content with placeholders\n$htmlContent = "<p>Blah blah blah [[studentCount]] students in the [[className]], taught by [[teacherCount]] teachers.</p>";\n\n// Function to replace placeholders with actual values\nfunction replacePlaceholders($content, $school) {\n    // Use regular expression to find all occurrences of [[...]]\n    return preg_replace_callback('/\[\[(.*?)\]\]/', function($matches) use ($school) {\n        // Get the data from the school object using the placeholder name as key\n        return htmlspecialchars($school->get($matches[1]), ENT_QUOTES, 'UTF-8');\n    }, $content);\n}\n\n// Replace placeholders in HTML content\n$finalContent = replacePlaceholders($htmlContent, $school);\n\necho $finalContent;\n?>