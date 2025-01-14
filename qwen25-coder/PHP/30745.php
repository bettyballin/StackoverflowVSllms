global $wpdb;\n$wpdb->show_errors();\n$contents = $wpdb->get_results(\n    $wpdb->prepare("SELECT salaries.id, name, remaining, contract_value, GROUP_CONCAT(provision_id) AS provision_ids \n                     FROM salaries \n                     LEFT JOIN contracts ON contracts.id = salaries.id \n                     GROUP BY salaries.id")\n);