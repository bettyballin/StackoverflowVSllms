function process_form(){\n         global $mysqli;\n\n         echo var_dump($_SESSION);\n\n         if (!isset($_SESSION['template']) || !is_a($_SESSION['template'], 'Template')) {\n             throw new Exception("Session does not contain a valid Template object.");\n         }\n\n         $Template = $_SESSION['template'];\n         $Template->name = $_POST['name'];\n         $Template->descript = $_POST['descript'];\n         $Template->user = $_SESSION['User'];\n         $Template->customer = $_SESSION['CustID'];\n         $Template->status = $_POST['status'];\n         $Template->insert();\n\n         //header("Location: template.php");\n     }