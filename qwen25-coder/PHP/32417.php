// application/models/Calendar_model.php\n\nclass Calendar_model extends CI_Model {\n\n    public function get_events_by_date($date) {\n        // Example query, adjust according to your database schema\n        $this->db->where('event_date', $date);\n        return $this->db->get('events')->result_array();\n    }\n}