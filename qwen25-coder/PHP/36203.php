$array = ['Birnen', 'Äpfel', 'Ungetüme', 'Apfel', 'Ungetiere', 'Österreich'];\n\n// Create a collator object with the desired locale and UTF-8 encoding\n$collator = new Collator('de_DE.UTF-8');\n\n// Sort the array using the collator's compare function\nif ($collator) {\n    $collator->asort($array);\n} else {\n    die("Collator creation failed");\n}\n\nvar_dump($array);