class ParentClass {\n    public $val = 'parent';\n\n    public function foo()\n    {\n        echo $this->val;\n    }\n}\n\nclass ChildClass extends ParentClass {\n    public $val = 'child';\n\n    public function foo()\n    {\n        parent::foo(); // outputs 'parent'\n    }\n}