SELECT \n    @main_id := m.id AS main_id,\n    m.meta_data,\n    (SELECT GROUP_CONCAT(another_table_id ORDER BY another_table_id SEPARATOR ',')\n     FROM sub s2\n     WHERE s2.main_id = @main_id) AS concatenated_another_table_ids\nFROM main m\nJOIN sub s ON m.id = s.main_id\nWHERE (@row_number:=IF(@current_main_id = m.id, @row_number + 1, 1)) = 1\nAND (@current_main_id:=m.id)\nORDER BY m.id;