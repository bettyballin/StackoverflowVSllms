class PersonFactory {\n    public static function createFromData(array $data): Person {\n        switch ($data['userType']) {\n            case 'admin':\n                return new Admin($data);\n            case 'buyer':\n                return new Buyer($data);\n            // Add other cases as needed...\n            default:\n                return new Person($data);\n        }\n    }\n}