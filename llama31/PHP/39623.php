$array = [...]; // your array\n\n$chunkSize = ceil(count($array) / 4);\n$chunks = array_chunk($array, $chunkSize);\n\nprint_r($chunks);