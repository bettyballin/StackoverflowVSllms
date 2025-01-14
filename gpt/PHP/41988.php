<?php\n$videoid = filter_input(INPUT_GET, 'videoid', FILTER_SANITIZE_STRING);\n\nif ($videoid) {\n    $get = new youtubeAPI();\n    $get->getVideoAPI($videoid);\n}\n\nclass youtubeAPI extends Exception {\n    function getVideoAPI($videoid) {\n        if ($videoid) {\n            $clientLibraryPath = 'library';\n            $oldPath = set_include_path(\n                get_include_path() . PATH_SEPARATOR . $clientLibraryPath\n            );\n\n            require_once 'Zend/Loader.php'; // the Zend dir must be in your include_path\n            // Additional code to handle the video API request\n        } else {\n            throw new Exception("Invalid video ID.");\n        }\n    }\n}\n?>