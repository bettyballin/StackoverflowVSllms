function generateUUID() {\n    return sprintf(\n        '%04x%04x-%04x-%04x-%04x-%04x%04x%04x',\n        mt_rand(0, 0xffff), mt_rand(0, 0xffff),\n        mt_rand(0, 0xffff),\n        mt_rand(0, 0x0fff) | 0x4000,\n        mt_rand(0, 0x3fff) | 0x8000,\n        mt_rand(0, 0xffff), mt_rand(0, 0xffff), mt_rand(0, 0xffff)\n    );\n}