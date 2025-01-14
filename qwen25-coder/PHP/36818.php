public function uploadPublicVideoAction()\n{\n    // Existing code remains same...\n\n    $session = new Zend_Session_Namespace('upload');\n    $progressBar = new Zend_ProgressBar(\n        new Zend_ProgressBar_Adapter_Callback(function($current, $max) use ($session) {\n            $session->progress = array(\n                'current' => $current,\n                'max'     => $max\n            );\n        })\n    );\n\n    // After the file upload (inside try block), update progress bar:\n    $progressBar->finish(); // Mark the process as complete\n}\n\npublic function getUploadProgressAction()\n{\n    $session = new Zend_Session_Namespace('upload');\n    if (!isset($session->progress)) {\n        echo json_encode(array(\n            'current' => 0,\n            'max'     => 1\n        ));\n    } else {\n        echo json_encode($session->progress);\n    }\n}