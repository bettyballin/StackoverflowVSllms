// models/Referral.php\npublic $validate = array(\n    'firstName' => array(\n        'rule' => 'notEmpty'\n    ),\n    'lastName' => array(\n        'rule' => 'notEmpty'\n    ),\n    'emailAddress' => array(\n        'rule' => 'email'\n    )\n);\n\n// models/Friend.php\npublic $validate = array(\n    'name' => array(\n        'rule' => 'notEmpty'\n    ),\n    'email' => array(\n        'rule' => 'email'\n    )\n);