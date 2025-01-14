function parseScript($content) {\n    $lines = explode("\n", $content);\n    $result = [];\n    $currentLine = '';\n\n    foreach ($lines as $line) {\n        // Check if the line ends with '!' and does not have an escaped '!'\n        if (substr($line, -1) === '!' && substr($line, -2, 1) !== '\\') {\n            if ($currentLine !== '') {\n                $currentLine .= ' ';\n            }\n            $currentLine .= rtrim($line, '!'); // Add line without trailing '!'\n        } else {\n            if ($currentLine !== '') {\n                $result[] = $currentLine . ' ' . trim($line);\n                $currentLine = '';\n            } else {\n                $result[] = trim($line);\n            }\n        }\n    }\n\n    // If there's any leftover line that was being merged\n    if ($currentLine !== '') {\n        $result[] = $currentLine;\n    }\n\n    return array_filter($result, function($value) { return $value !== ''; });\n}\n\n// Example usage:\n$content = "ZOMFG\n&This is a comment !\non multiple !\nlines.\n(show \"Hello, !\nWorld!!\");\n";\n$result = parseScript($content);\nprint_r($result);