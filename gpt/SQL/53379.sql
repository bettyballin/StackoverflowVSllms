SELECT \n    tp.person_id,\n    rp.person_id AS related_person_id,\n    rp.relationship_type_id\nFROM \n    people tp\nJOIN \n    people rp\nON \n    tp.family_number = rp.family_number\n    AND tp.person_id != rp.person_id\n    AND rp.relationship_type_id = 1\nWHERE \n    tp.relationship_type_id = 1; -- parent