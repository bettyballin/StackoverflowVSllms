<?php\n\nfunction parseDiffForClassesAndMethods($diffContent) {\n    $lines = explode("\n", $diffContent);\n    $changedClasses = [];\n    $changedFunctions = [];\n    $currentClass = null;\n\n    foreach ($lines as $line) {\n        if (preg_match('/^\+\+/', $line)) {\n            // Reset current class on new file\n            $currentClass = null;\n        } elseif (preg_match('/^\\+class\s+(\w+)/', $line, $matches)) {\n            // Capture new class being added/modified\n            $currentClass = $matches[1];\n        } elseif (preg_match('/^\\+function\s+(\w+)\(/', $line, $matches) && $currentClass) {\n            // Capture function within a class\n            $changedFunctions[$currentClass][] = $matches[1];\n        } elseif (preg_match('/^\\+\s*(public|private|protected)?\s*function\s+(\w+)\(/', $line, $matches)) {\n            // Capture standalone functions or methods in global context\n            if ($currentClass) {\n                $changedFunctions[$currentClass][] = $matches[2];\n            } else {\n                $changedFunctions['global'][] = $matches[2];\n            }\n        } elseif (preg_match('/^\\+\s*class\s+(\w+)/', $line, $matches)) {\n            // Capture class in global scope\n            $changedClasses[] = $matches[1];\n            $currentClass = $matches[1];\n        }\n    }\n\n    return ['classes' => $changedClasses, 'methods' => $changedFunctions];\n}\n\n// Example diff content (as a string)\n$diffContent = <<<EOF\n++ b/Example.php\n@@ -2,6 +2,8 @@\n class MyClass {\n     private \$myVariable;\n\n+    public function newMethod() {\n+    }\n \n     public function existingMethod() {\n     }\nEOF;\n\n$result = parseDiffForClassesAndMethods($diffContent);\n\necho "Changed Classes:\n";\nforeach ($result['classes'] as $class) {\n    echo "$class\n";\n}\n\necho "\nChanged Methods:\n";\nforeach ($result['methods'] as $class => $methods) {\n    echo "$class: ";\n    echo implode(', ', $methods);\n    echo "\n";\n}