class TestExcel extends PHPExcel {\n    private $number;\n\n    public function __construct($number){\n        parent::__construct();\n\n        $this->number = $number;\n        echo number_format($this->number->getNumber(), 0, '', ''); exit();\n    }\n}