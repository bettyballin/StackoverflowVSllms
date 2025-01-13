use Doctrine\DBAL\Types\StringType;\nuse Doctrine\ORM\Query\Parameter;\n\n$duration = 24; // in hours\n\n$reset = new PasswordReset();\n$reset->code = md5(uniqid());\n$reset->expires = "now() + interval :duration hours";\n$reset->User = $user;\n\n$param = new Parameter(':duration', $duration, \PDO::PARAM_INT);\n$reset->save(['expires' => $param]);