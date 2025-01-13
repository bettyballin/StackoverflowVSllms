class HasFriends\n{\n    private $__friends = array('MyFriend', 'OtherFriend');\n\n    public function __get($key)\n    {\n        $trace = debug_backtrace();\n        if(isset($trace[1]['class']) && in_array($trace[1]['class'], $this->__friends)) {\n            return $this->$key;\n        }\n\n        // normal __get() code here\n\n        trigger_error('Cannot access private property ' . __CLASS__ . '::$' . $key, E_USER_ERROR);\n    }\n\n    public function __set($key, $value)\n    {\n        $trace = debug_backtrace();\n        if(isset($trace[1]['class']) && in_array($trace[1]['class'], $this->__friends)) {\n            return $this->$key = $value;\n        }\n\n        // normal __set() code here\n\n        trigger_error('Cannot access private property ' . __CLASS__ . '::$' . $key, E_USER_ERROR);\n    }\n}