$class_name = 'ClassPeer';\n$method_name = 'doSomething';\n\n// Using curly braces\n{$class_name}::{$method_name}();\n\n// Alternatively, using call_user_func\ncall_user_func([$class_name, $method_name]);