public function get_field2_options($field1_value)\n{\n    $this->db->where('field1', $field1_value);\n    return $this->db->get('related_table')->result();\n}