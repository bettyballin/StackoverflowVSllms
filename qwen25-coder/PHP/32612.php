$allowed_files = ['brochure1.pdf', 'brochure2.pdf']; // Define allowed filenames\n\nif (in_array($_POST['brochure'], $allowed_files)) {\n    if (file_exists($_POST['brochure'])) {\n        // do some stuff\n    } else {\n        // handle the case where file does not exist\n    }\n} else {\n    // handle invalid input\n}