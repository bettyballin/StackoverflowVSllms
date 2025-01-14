<?php\n$rootDir = '/path/to/svn/repositories';\n$svnRepos = [];\n\nif (is_dir($rootDir)) {\n    if ($handle = opendir($rootDir)) {\n        while (false !== ($entry = readdir($handle))) {\n            $fullPath = $rootDir . '/' . $entry;\n            // Check if it's a directory and not the special entries\n            if (is_dir($fullPath) && !in_array($entry, ['.', '..'])) {\n                // Assuming each repository has an 'svn' folder or some marker to identify them\n                if (file_exists($fullPath . '/format')) {\n                    $svnRepos[] = $entry;\n                }\n            }\n        }\n        closedir($handle);\n    }\n}\n\necho '<ul>';\nforeach ($svnRepos as $repo) {\n    echo '<li><a href="http://yourserver/svn/' . htmlspecialchars($repo) . '">' . htmlspecialchars($repo) . '</a></li>';\n}\necho '</ul>';\n?>