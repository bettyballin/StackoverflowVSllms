// Procedural approach\nfunction calculate_area($width, $height) {\n    return $width * $height;\n}\n$area = calculate_area(5, 10);\n\n// Object-oriented approach\nclass Rectangle {\n    private $width;\n    private $height;\n\n    public function __construct($width, $height) {\n        $this->width = $width;\n        $this->height = $height;\n    }\n\n    public function calculateArea() {\n        return $this->width * $this->height;\n    }\n}\n$rectangle = new Rectangle(5, 10);\n$area = $rectangle->calculateArea();