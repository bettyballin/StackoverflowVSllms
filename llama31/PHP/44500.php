if (basename($_SERVER['PHP_SELF']) == basename(__FILE__)) {\n    die("Direct access not permitted");\n}