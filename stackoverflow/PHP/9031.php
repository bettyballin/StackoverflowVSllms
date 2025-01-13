function image_createtruecolortransparent($x,$y) \n{\n    $i = imagecreatetruecolor($x,$y);\n    $b = imagecreatefromstring(base64_decode(image_blankpng()));\n    imagealphablending($i,false);\n    imagesavealpha($i,true);\n    imagecopyresized($i,$b,0,0,0,0,$x,$y,imagesx($b),imagesy($b));\n    return $i;\n}\n\nfunction image_blankpng()\n{\n    $c = "iVBORw0KGgoAAAANSUhEUgAAACgAAAAoCAYAAACM/rhtAAAABGdBTUEAAK/INwWK6QAAABl0RVh0U29m";\n    $c .= "dHdhcmUAQWRvYmUgSW1hZ2VSZWFkeXHJZTwAAADqSURBVHjaYvz//z/DYAYAAcTEMMgBQAANegcCBNCg";\n    $c .= "dyBAAA16BwIE0KB3IEAADXoHAgTQoHcgQAANegcCBNCgdyBAAA16BwIE0KB3IEAADXoHAgTQoHcgQAAN";\n    $c .= "egcCBNCgdyBAAA16BwIE0KB3IEAADXoHAgTQoHcgQAANegcCBNCgdyBAAA16BwIE0KB3IEAADXoHAgTQ";\n    $c .= "oHcgQAANegcCBNCgdyBAAA16BwIE0KB3IEAADXoHAgTQoHcgQAANegcCBNCgdyBAAA16BwIE0KB3IEAA";\n    $c .= "DXoHAgTQoHcgQAANegcCBNCgdyBAgAEAMpcDTTQWJVEAAAAASUVORK5CYII=";\n\n    return $c;\n} 