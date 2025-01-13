<?php defined('SYSPATH') or die('No direct access allowed.');\n\nclass AbsentMethodHook {\n    public static function redirect_to_index($e) {\n        if ($e instanceof Kohana_Exception && $e->getCode() === 404) {\n            $request = Request::current();\n            $uri = $request->uri();\n            $controller = $request->controller();\n            $action = 'index';\n\n            // Get the arguments from the URI\n            $args = array_slice(explode('/', $uri), 2);\n\n            // Redirect to the index method with arguments\n            Request::factory($controller . '/' . $action . '/' . implode('/', $args))->execute();\n        }\n    }\n}\n\n// Add the hook to the system\nEvent::add('system.error', array('AbsentMethodHook', 'redirect_to_index'));