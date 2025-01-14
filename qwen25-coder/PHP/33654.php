// Load the rows (selected modules) needed for this user into an array\n$modules['modulearr'] = $this->module_model->getModuleUser();\n\nforeach ($modules['modulearr'] as $module) {\n    // Get the module name from the object\n    $name = $module->mod_name;\n\n    // Load the model dynamically using CodeIgniter's loader class\n    $model_name = $name . '_model';\n    $this->load->model($model_name);\n\n    // Call a method on the model dynamically and get the data\n    $data[$name] = $this->$model_name->get();\n\n    // Pass the data to the view\n    $this->load->view($name . '_view', ['module_data' => $data[$name]]);\n}