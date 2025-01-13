class plzComplicateMyLife {\n    public $vehicle;\n    public $kindVehicle;\n    public $dynamicFunction;\n\n    public function __construct($vehicle, $kindVehicle) {\n        $this->kindVehicle = $kindVehicle;\n        $this->vehicle = $vehicle;\n        switch ($kindVehicle) {\n            case 'cycle':\n                $this->dynamicFunction = "isACycle";\n                break;\n            case 'car':\n                $this->dynamicFunction = "isACar";\n                break;\n        }\n        $this->{$this->dynamicFunction}($this->vehicle);\n    }\n\n    public function isACycle($vehicle) {\n        echo 'im a cycle, model: ' . $vehicle . '<br />';\n    }\n\n    public function isACar($vehicle) {\n        echo 'im a car, model: ' . $vehicle . '<br />';\n    }\n\n    public function printKind() {\n        $this->{$this->dynamicFunction}($this->vehicle);\n    }\n}\n\n$maserati = new plzComplicateMyLife('maserati4', 'car');\n$ducati = new plzComplicateMyLife('ducati', 'cycle');\n\n$maserati->printKind();\n$ducati->printKind();