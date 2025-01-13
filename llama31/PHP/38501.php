class split_db extends phpbb_db {\n    private $write_db;\n    private $read_db;\n\n    public function __construct($write_config, $read_config) {\n        $this->write_db = new phpbb_db($write_config);\n        $this->read_db = new phpbb_db($read_config);\n    }\n\n    public function sql_query($query) {\n        if (is_write_query($query)) {\n            return $this->write_db->sql_query($query);\n        } else {\n            return $this->read_db->sql_query($query);\n        }\n    }\n\n    private function is_write_query($query) {\n        // Determine if the query is a write query (INSERT, UPDATE, DELETE)\n        // You can use a simple string match or a more complex SQL parser\n        return strpos($query, 'INSERT') !== false || strpos($query, 'UPDATE') !== false || strpos($query, 'DELETE') !== false;\n    }\n}