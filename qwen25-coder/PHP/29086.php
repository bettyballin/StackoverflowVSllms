function echoFormattedNumber($number) {\n    // Convert the number to a string and remove unnecessary zeroes\n    $formatted = rtrim(rtrim(number_format($number, 10), '0'), '.');\n    echo $formatted;\n}\n\n// Usage\nechoFormattedNumber(2);      // Outputs: 2\nechoFormattedNumber(2.2000); // Outputs: 2.2\nechoFormattedNumber(100);    // Outputs: 100