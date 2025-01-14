$data = "123.123.123a 123a.123";\n\n$result = preg_replace('/[^0-9.]+/', '', $data); // Remove non-numeric and non-dot characters\n$result = preg_replace('/(?<=\..*)\./', '', $result); // Remove additional dots after the first\n\necho $result; // Output: 123.123123123.123