class Property {\n  private $db;\n\n  public function __construct($db) {\n    $this->db = $db;\n  }\n\n  public function saveProperty() {\n    $sql = "<<query goes here>>";\n    mysql_query($sql, $this->db);\n\n    if (mysql_affected_rows() > 0) {\n      echo "<h3>Data was saved</h3>";\n    } else {\n      echo "<h3>Error saving data</h3>";\n    }\n  }\n}