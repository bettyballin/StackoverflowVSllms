ob_start();\nob_start('ob_gzhandler');\n\n  ... output the page content...\n\nob_end_flush();  // The ob_gzhandler one\n\nheader('Content-Length: '.ob_get_length());\n\nob_end_flush();  // The main one