<?php\n\nfunction buildTree($directory) {\n    $iterator = new RecursiveDirectoryIterator($directory);\n    $tree     = array();\n\n    foreach (new RecursiveIteratorIterator($iterator, RecursiveIteratorIterator::SELF_FIRST) as $file) {\n        if ($file->isDir()) {\n            // Add a directory node\n            $pathParts = explode('/', substr($file->getPathname(), strlen($directory)));\n            $node = &$tree;\n\n            while (!empty($part = array_shift($pathParts))) {\n                if (!isset($node[$part])) {\n                    $node[$part] = [];\n                }\n                $node = &$node[$part];\n            }\n        } else {\n            // Add a file node\n            $pathParts = explode('/', substr($file->getPathname(), strlen($directory)));\n            $fileName  = array_pop($pathParts);\n            $node      = &$tree;\n\n            while (!empty($part = array_shift($pathParts))) {\n                if (!isset($node[$part])) {\n                    $node[$part] = [];\n                }\n                $node = &$node[$part];\n            }\n\n            if (count($pathParts) > 0) {\n                // If it's not a top-level file\n                $node[] = $fileName;\n            } else {\n                // It's a top-level file\n                $tree[] = $fileName;\n            }\n        }\n    }\n\n    return $tree;\n}\n\n$directoryPath = '/path/to/your/vacation/pictures';\n$directoryTree = buildTree($directoryPath);\n\nprint_r($directoryTree);\n\n?>