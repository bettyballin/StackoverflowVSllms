$row = $db->get_row($sql);\nif ($row) {\n    return $row->folder;\n} else {\n    return FALSE;\n}