class YourModel extends MY_Model {\n       public function __construct() {\n           parent::__construct();\n           // Now you can use $this->db for the default database and $this->db2 for the stats database.\n       }\n\n       public function example_function() {\n           // Using the default database connection\n           $query = $this->db->get('some_table');\n           \n           // Using the second database connection\n           $query_stats = $this->db2->get('some_stats_table');\n\n           return [$query->result(), $query_stats->result()];\n       }\n   }