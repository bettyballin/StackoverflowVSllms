<?php\nfunction send_custom_header() {\n    header('X-Custom-Header: MyCustomValue');\n}\n\nob_start(); // Start output buffering\n\n// Your code here...\n\nsend_custom_header(); // Send headers - this can be called anytime before sending any other outputs or flushing the buffer\nob_end_flush(); // Flush the buffer and send headers with buffered content\n?>