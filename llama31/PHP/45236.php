public function formatDate($date)\n{\n    return date("M/d/Y", strtotime($date));\n}