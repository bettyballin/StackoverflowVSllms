<?php\n// Prevent caching\nheader("Expires: Sun, 01 Jan 2006 01:00:00 GMT"); // A date in the past\nheader("Cache-Control: no-store, no-cache, must-revalidate");\nheader("Cache-Control: post-check=0, pre-check=0", false);\nheader("Pragma: no-cache");\n\n// Your existing PHP code to handle file downloads continues below...\n\n?>