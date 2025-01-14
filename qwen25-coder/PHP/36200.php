class FormValidator {\n    private $errors = [];\n\n    public function validate($data){\n        if (!filter_var($data['email'], FILTER_VALIDATE_EMAIL)) {\n            $this->errors[] = 'Email is not valid.';\n        }\n\n        // Add more validation rules as necessary\n\n        return empty($this->errors);\n    }\n\n    public function getErrors(){\n        return $this->errors;\n    }\n}