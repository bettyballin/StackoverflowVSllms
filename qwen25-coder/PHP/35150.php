$lock = fopen("/path/to/lockfile", "c+");\n   if (flock($lock, LOCK_EX)) {\n       // critical section here (write cache)\n       flock($lock, LOCK_UN);\n   }\n   fclose($lock);