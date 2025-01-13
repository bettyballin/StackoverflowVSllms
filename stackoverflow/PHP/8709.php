function array_set_depth($array, $depth = -1)\n{\n  $subdepth = $depth + 1;\n  if ($depth < 0) {\n    foreach ($array as $key => $subarray) {\n      $temp[$key] = array_set_depth(($subarray), $subdepth);\n    }\n  }\n  if ($array['hasChildren'] && isset($array['children'])) {\n    foreach ($array['children'] as $key => $subarray) {\n      $temp[$key] = array_set_depth($subarray, $subdepth);\n    }\n    $array['children'] = $temp;\n  }\n  $array['depth'] = $depth;\n  return $array;\n}