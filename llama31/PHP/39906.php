if (headers_sent()) {\n    // headers have already been sent, cannot send new headers\n} else {\n    // it's safe to send new headers\n}