function checkOracleExtensions() {\n    $oci8_installed = extension_loaded('oci8');\n    $pdo_oci_installed = extension_loaded('pdo_oci');\n\n    if ($oci8_installed && $pdo_oci_installed) {\n        return 'Both oci8 and pdo_oci extensions are installed.';\n    } elseif ($oci8_installed) {\n        return 'oci8 extension is installed.';\n    } elseif ($pdo_oci_installed) {\n        return 'pdo_oci extension is installed.';\n    } else {\n        return 'Neither oci8 nor pdo_oci extensions are installed.';\n    }\n}\n\n// Example usage\necho checkOracleExtensions();