<?php\nclass FormBuilder {\n    private $fields = [];\n    private $method;\n    private $action;\n\n    public function __construct($action = '', $method = 'POST') {\n        $this->action = $action;\n        $this->method = $method;\n    }\n\n    public function addField($type, $name, $label = '', $options = []) {\n        $this->fields[] = [\n            'type' => $type,\n            'name' => $name,\n            'label' => $label,\n            'options' => $options\n        ];\n    }\n\n    public function render() {\n        $form = "<form action='{$this->action}' method='{$this->method}'>";\n\n        foreach ($this->fields as $field) {\n            $form .= $this->renderField($field);\n        }\n\n        $form .= '<input type="submit" value="Submit">';\n        $form .= '</form>';\n\n        return $form;\n    }\n\n    private function renderField($field) {\n        $html = '';\n\n        if (!empty($field['label'])) {\n            $html .= "<label for='{$field['name']}'>{$field['label']}</label>";\n        }\n\n        switch ($field['type']) {\n            case 'text':\n            case 'email':\n            case 'password':\n                $html .= "<input type='{$field['type']}' name='{$field['name']}' id='{$field['name']}'>";\n                break;\n\n            case 'select':\n                $html .= "<select name='{$field['name']}' id='{$field['name']}'>";\n                foreach ($field['options'] as $value => $display) {\n                    $html .= "<option value='{$value}'>{$display}</option>";\n                }\n                $html .= "</select>";\n                break;\n\n            case 'textarea':\n                $html .= "<textarea name='{$field['name']}' id='{$field['name']}'></textarea>";\n                break;\n\n            // Add more types as needed\n\n            default:\n                throw new Exception("Field type '{$field['type']}' is not supported");\n        }\n\n        $html .= '<br>';\n        return $html;\n    }\n}\n\n// Example usage\n$form = new FormBuilder('submit.php', 'POST');\n$form->addField('text', 'username', 'Username');\n$form->addField('password', 'password', 'Password');\n$form->addField('email', 'email', 'Email');\n$form->addField('select', 'gender', 'Gender', ['male' => 'Male', 'female' => 'Female']);\n$form->addField('textarea', 'bio', 'Bio');\n\necho $form->render();\n?>