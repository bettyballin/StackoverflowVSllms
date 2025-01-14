amespace Vendor\ClassName;\n\nclass HelperOptions {\n    const FIRST_OPTION = 1;\n    const SECOND_OPTION = 2;\n\n    public $option;\n    public $otherArgument;\n\n    public function __construct($option, $otherArgument) {\n        $this->option = $option;\n        $this->otherArgument = $otherArgument;\n    }\n}\n\nclass Helper {\n    private $options;\n\n    public function __construct(HelperOptions $options) {\n        $this->options = $options;\n    }\n\n    // Use $this->options->option and $this->options->otherArgument as needed\n}