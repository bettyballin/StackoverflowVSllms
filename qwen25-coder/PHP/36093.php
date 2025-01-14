class ClassA{\n    static function call($class = null) {\n        if ($class === null) {\n            $class = get_called_class();\n        }\n        return call_user_func(array($class, 'inner'));\n    }\n\n    static function inner(){\n        return "Class A";\n    }   \n}\n\nclass ClassB extends ClassA{\n    static function inner(){\n        return "Class B";\n    }\n}\n\necho "<p>Class A = " . ClassA::call();\necho "<p>Class B = " . ClassB::call('ClassB');