// Set umask to default value for dirs: 0777 - 022 = 0755 (rwxr-xr-x)\n$oldUmask = umask(0022);\nmkdir($path, 0777);\numask($oldUmask);\n\n// Attempt to check and set writable permission\n// Note: This won't work as expected on Windows for changing directory attributes\nchmod($path, 0755);\n\n// If the directory becomes readonly, the issue might be related to file system restrictions