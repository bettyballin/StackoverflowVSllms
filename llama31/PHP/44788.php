function getValue($cn, $comando) {\n    $q = $cn->prepare($comando);\n    $q->execute();\n    $retorno = $q->fetchAll();\n    return $retorno[0][0];\n}