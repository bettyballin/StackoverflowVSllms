if (isset($tx->custom_fields[0]->custom_field)) {\n    foreach ($tx->custom_fields[0]->custom_field as $field) {\n        $affiliateID = $field->custom_field_value[0]->tagData;\n    }\n}