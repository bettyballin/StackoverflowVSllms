if (isset($_POST['fname'])) {\n    $fname = htmlspecialchars(trim($_POST['fname']));\n    $lname = htmlspecialchars(trim($_POST['lname']));\n    $oname = htmlspecialchars(trim($_POST['oname'])); // Capture the SELECT value\n\n    // DO SOMETHING with fname, lname, and oname\n}