SELECT cf.name, cfv.value\nFROM custom_fields cf\nJOIN custom_field_values cfv ON cf.id = cfv.field_id\nWHERE cf.entity_id = 1;