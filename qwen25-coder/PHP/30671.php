$result = array_column(array_map(function($e) { return explode('=', $e, 2); }, $array), 1, 0);