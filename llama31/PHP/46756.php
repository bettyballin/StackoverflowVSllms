function procLogin($user, $pass, $remember) {\n    global $session, $form;\n    $retval = $session->login($user, $pass, $remember);\n    if ($retval) {\n        $userData = array('role' => $session->getUserRole()); // assuming you have a getUserRole() method\n        header("Content-Type: application/json");\n        echo json_encode($userData);\n        exit;\n    } else {\n        // handle login error\n    }\n}