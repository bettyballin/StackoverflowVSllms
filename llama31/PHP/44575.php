ob_implicit_flush(true);\nforeach ($items as $item) {\n    // Process the item...\n    echo "Processing $item...<br>";\n    // No need to call ob_flush() or flush() explicitly\n    usleep(50000); // 50ms\n}