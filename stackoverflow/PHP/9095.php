<?php\n\n$fp = fopen("/tmp/counter.txt", "r+");\n\necho "Attempt to lock\n";\nif (flock($fp, LOCK_EX)) {\n  echo "Locked\n";\n  // Read current value of the counter and increment\n  $cntr = fread($fp, 80);\n  $cntr = intval($cntr) + 1;\n\n  // Pause to prove that race condition doesn't exist\n  sleep(5);\n\n  // Write new value to the file\n  ftruncate($fp, 0);\n  fseek($fp, 0, SEEK_SET);\n  fwrite($fp, $cntr);\n  flock($fp, LOCK_UN); // release the lock\n  fclose($fp);\n}\n\n?>