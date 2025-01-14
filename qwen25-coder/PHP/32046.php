// Start output buffering if needed (optional)\nob_start();\n\n// Record user entered\nrecordUserEntered();\n\n// Ignore user aborts and continue script execution even after disconnection\nignore_user_abort(true);\n\nwhile (true) {\n    // Check connection status\n    if (connection_status() != CONNECTION_NORMAL) {\n        break; // Exit loop if client is no longer connected\n    }\n\n    // Fetch changes in state since last awake\n    $changes = fetchChanges();\n\n    // Send changes to user\n    echo json_encode($changes);\n    ob_flush(); // Flush the output buffer\n\n    // Sleep for 5 seconds\n    sleep(5);\n}\n\n// Record user exit after loop ends (client disconnect or some other condition)\nrecordUserExit();