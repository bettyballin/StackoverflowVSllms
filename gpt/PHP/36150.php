class wrapController extends baseController {\n    function dosomethingFunction() {\n        global $globalVar;\n        require 'old_dosomething.function.php';\n        $this->view('old_dosomething_view');\n    }\n}