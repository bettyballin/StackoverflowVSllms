if (!isset($_SERVER['MY_SECRET_TOKEN']) || $_SERVER['MY_SECRET_TOKEN'] !== 'mysecretvalue') {\n    die('Unauthorized access.');\n}