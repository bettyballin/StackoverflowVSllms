// After cURL request, use JavaScript to redirect user\necho <<<EOT\n<script>\n    // Optional: You can also pass the response from cURL if needed\n    window.location.href = 'https://example.com/results.php';\n</script>\nEOT;