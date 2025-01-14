function safe_file_write($filename, $data) {\n    $lockfile = $filename . '.lock';\n    $fp = fopen($lockfile, 'w');\n\n    // Attempt to obtain an exclusive lock\n    while (!flock($fp, LOCK_EX)) {\n        // If the lock is not obtained, wait for 100ms and try again\n        usleep(100000);\n    }\n\n    // Write data to the file\n    $file = fopen($filename, 'a');\n    fwrite($file, $data);\n    fclose($file);\n\n    // Release the lock\n    flock($fp, LOCK_UN);\n    fclose($fp);\n    unlink($lockfile);\n}\n\n// Usage\nsafe_file_write('logfile.txt', "Logging data\n");