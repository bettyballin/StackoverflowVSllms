if ($_error == 0) {\n    // No Error, do nothing or something appropriate if needed\n} elseif ($_error == 3) {\n    // Specific error (No numbers allowed)\n    // "bunch of stuff happens"\n    echo $error_msg[3];\n} else {\n    // All other errors end the script with an echo statement\n    echo $error_msg[$_error];\n}