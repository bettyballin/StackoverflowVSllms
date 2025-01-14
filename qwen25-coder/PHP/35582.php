// app/Model/Referral.php\n\nclass Referral extends AppModel {\n    public $hasMany = array(\n        'Friend' => array(\n            'className' => 'Friend',\n            'foreignKey' => 'referral_id'\n        )\n    );\n\n    public $validate = array(\n        'firstName' => array(\n            'required' => true,\n            'rule' => 'alphaNumeric'\n        ),\n        'lastName' => array(\n            'required' => true,\n            'rule' => 'alphaNumeric'\n        ),\n        'emailAddress' => array(\n            'required' => true,\n            'email' => true\n        )\n    );\n}