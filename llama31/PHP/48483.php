function checkLoginWrapper($group) {\n    $theSentry = new Sentry();\n    return $theSentry->checkLogin('', '', $group, '', '');\n}