class myclass {\n    public function myfunction($some_external_var)  {\n        if (isset($some_external_var)) {\n            // do something ...\n            echo "Variable is set to: " . ($some_external_var ? 'true' : 'false');\n        } else {\n            echo "Variable is not set.";\n        }\n    }\n}\n\n$some_external_var = true;\n\n$obj = new myclass();\n$obj->myfunction($some_external_var);