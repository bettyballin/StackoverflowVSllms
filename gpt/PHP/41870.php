class Score\n{\n    var $score;\n    var $name;\n    var $dept;\n    var $date;\n\n    function __construct($score, $name, $dept, $date)\n    {\n        $this->score = $score;\n        $this->name = $name;\n        $this->dept = $dept;\n        $this->date = $date;\n    }\n\n    function return_score() {\n        return $this->score . ", " . $this->name . ", " . $this->dept . ", " . $this->date;\n    }\n}\n\n$newscore = new Score("131313","James", "Marketing", "19/05/2008");\necho $newscore->return_score();