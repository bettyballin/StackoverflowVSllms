<?php\ndefined('BASEPATH') OR exit('No direct script access allowed');\n\nclass Hotel_model extends CI_Model {\n\n    public function get_room_availability($hotel_id, $room_id) {\n        // Your database logic here\n        // For example:\n        \n        $this->db->where('hotel_id', $hotel_id);\n        $this->db->where('room_id', $room_id);\n        \n        $query = $this->db->get('room_availability');\n        return $query->result();\n    }\n}\n?>