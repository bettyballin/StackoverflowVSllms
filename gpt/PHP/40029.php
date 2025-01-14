<?php\n\n$data = [\n    [\n        'title' => 'Star Trek - Viaje a las estrellas',\n        'country' => 'Venezuela, Spain, long title, poster title'\n    ],\n    [\n        'title' => 'Viaje a Las Estrellas',\n        'country' => 'Venezuela'\n    ]\n];\n\nforeach ($data as &$item) {\n    if (isset($item['country'])) {\n        $countryArray = array_map('trim', explode(',', $item['country']));\n        $item['country'] = (count($countryArray) > 1) ? $countryArray : $countryArray[0];\n    }\n}\n\nprint_r($data);\n?>