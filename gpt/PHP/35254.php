<?php\n// Sample variables\n$a = 'hello';\n$b = ' world';\n\n// Function to replace tags with variable values\nfunction replaceTags($template, $variables) {\n    return preg_replace_callback('/\{@(.*?)\}/', function ($matches) use ($variables) {\n        $tag = $matches[1];\n        // Recursively process the tag\n        if (isset($variables[$tag])) {\n            return replaceTags($variables[$tag], $variables);\n        }\n        return $matches[0]; // Return the original tag if no replacement found\n    }, $template);\n}\n\n// Define the template and variables\n$template = 'This is my test {@a{@b}} string.';\n$variables = [\n    'a' => $a,\n    'b' => $b\n];\n\n// Perform the replacement\n$output = replaceTags($template, $variables);\n\necho $output; // Output: This is my test hello world string.\n?>