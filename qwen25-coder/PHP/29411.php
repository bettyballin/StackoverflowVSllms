private function getValidLanguage($my_parameters) {\n    $language = $my_parameters->getLanguage();\n    if (is_null($language) || !$language->isValid()) {\n        throw new Exception('Language must be valid.');\n    }\n    return $language;\n}\n\npublic function buildBody() {\n    $language = $this->getValidLanguage($my_parameters);\n    // Use the validated $language object here\n}