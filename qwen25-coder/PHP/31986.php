<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    if (isset($_POST['formSubmit']) && $_POST['formSubmit'] === 'form1') {\n        // Handle form1 submission\n        echo "Form 1 was submitted.";\n    } elseif (isset($_POST['formSubmit']) && $_POST['formSubmit'] === 'form2') {\n        // Handle form2 submission\n        echo "Form 2 was submitted.";\n    }\n}\n?>