if ($registrationFailed) {\n    header("Location: yourpage.php?form=account-form");\n    exit;\n} elseif ($loginFailed) {\n    header("Location: yourpage.php?form=login-form");\n    exit;\n}