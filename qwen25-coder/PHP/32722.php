<?php\n\n// Define a unique key for caching the non-existence of files\n$cacheKey = 'file_exists_' . md5(APPLICATION_PATH . '/controllers/company/LoginController.php');\n\nif (apc_fetch($cacheKey) === false) {\n    // If the file's existence is not cached, check it on the filesystem\n    if (!file_exists(APPLICATION_PATH . '/controllers/company/LoginController.php')) {\n        // Cache the non-existence of the file for a certain period\n        apc_store($cacheKey, 'not_found', 3600); // Cache this result for up to an hour\n    } else {\n        include_once APPLICATION_PATH . '/controllers/company/LoginController.php';\n        if (class_exists("Company_LoginController")) {\n            echo 'customer-specific controller exists';\n            return;\n        }\n    }\n}\n\n// If the file is not found or does not exist, fall back to the default controller\ninclude_once APPLICATION_PATH . '/controllers/LoginController.php';\necho 'customer-specific controller does not exist; using default';\n\n?>