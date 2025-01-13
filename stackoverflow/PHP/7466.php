function humanReadableOctets($octets)\n{\n    $units = array('B', 'kB', 'MB', 'GB', 'TB'); // ...etc\n\n    for ($i = 0, $size =$octets; $size>1024; $size=$size/1024)\n        $i++;\n\n    return number_format($size, 2) . ' ' . $units[min($i, count($units) -1 )];\n} 