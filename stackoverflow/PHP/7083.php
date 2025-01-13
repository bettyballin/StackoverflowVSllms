function getDomain($url) {\n  $pieces = parse_url($url);\n  $domain = isset($pieces['host']) ? $pieces['host'] : '';\n  if (preg_match('/(?P<domain>[a-z0-9][a-z0-9\-]{1,63}\.[a-z\.]{2,6})$/i', $domain, $regs)) {\n    return $regs['domain'];\n  }\n  return false;\n}