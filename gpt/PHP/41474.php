function toBeCalled( &$parameter ) {\n    //...Do Something...\n}\n\n$changingVar = 'passThis';\n$parameters = array( &$changingVar ); // Use the reference operator &\ncall_user_func_array( 'toBeCalled', $parameters );