class ModuleController extends CI_Controller {\n\n    public function index() {\n        // Load the module model\n        $this->load->model('module_model');\n\n        // Get the modules selected by the user\n        $modules = $this->module_model->getModuleUser();\n\n        foreach ($modules as $module) {\n            // Get the module name\n            $module_name = $module->mod_name;\n\n            // Sanitize and validate the module name\n            if ($this->is_valid_module($module_name)) {\n                // Dynamically load the model for the module\n                $model_name = $module_name . '_model';\n\n                if ($this->load->model($model_name, '', TRUE)) {\n                    // Dynamically call the model's method to get data\n                    $data = $this->$model_name->get();\n\n                    // Load the view and pass the data\n                    $this->load->view($module_name . '_view', $data);\n                } else {\n                    // Handle error when model cannot be loaded\n                    log_message('error', "Model $model_name could not be loaded.");\n                }\n            } else {\n                // Handle invalid module name\n                log_message('error', "Invalid module name: $module_name.");\n            }\n        }\n    }\n\n    private function is_valid_module($module_name) {\n        // Implement your validation logic here\n        // Example: Check against a whitelist of valid module names\n        $valid_modules = ['module1', 'module2', 'module3'];\n        return in_array($module_name, $valid_modules);\n    }\n}