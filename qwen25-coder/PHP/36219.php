use Drupal\field\Entity\FieldStorageConfig;\nuse Drupal\field\Entity\FieldConfig;\n\n// Define field storage.\n$field_storage = FieldStorageConfig::create([\n  'field_name' => 'field_manufacturer',\n  'entity_type' => 'node',\n  'type' => 'string',\n]);\n$field_storage->save();\n\n// Create a field instance for the article content type\n$field_instance = FieldConfig::create([\n  'field_storage' => $field_storage,\n  'bundle' => 'retro_game_console',\n  'label' => 'Manufacturer',\n]);\n$field_instance->save();