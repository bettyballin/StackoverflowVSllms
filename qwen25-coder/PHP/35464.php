if (isset($GLOBALS['argc']) && $GLOBALS['argc'] > 0) {\n    // Script is running from the command line\n    echo "Invoked from command-line\n";\n} else {\n    // Script is likely being served by a web server\n    echo "Invoked via web server\n";\n}