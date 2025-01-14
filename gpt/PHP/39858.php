<?php\nsession_start();\n\n$timeout_duration = 1800;\n$session_expired = false;\n\nif (isset($_SESSION['LAST_ACTIVITY'])) {\n    $elapsed_time = time() - $_SESSION['LAST_ACTIVITY'];\n    if ($elapsed_time >= $timeout_duration) {\n        $session_expired = true;\n        session_unset();\n        session_destroy();\n    }\n}\n\necho json_encode(['session_expired' => $session_expired]);\n?>