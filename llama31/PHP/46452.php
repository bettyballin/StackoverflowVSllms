$data = $_REQUEST['in'];\n$raw = base64_decode(strtr($data, '-_', '+/'));