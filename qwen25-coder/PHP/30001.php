Event::add('request.start', function($request) {\n    $request->myClass = new MyClass();\n});