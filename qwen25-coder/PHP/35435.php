$this->db->select('comments.created_at, comments.section_id, comments.submittedby_id, users.username, comments.text, sections.name');\n$this->db->order_by('comments.created_at', 'desc');\n\n// Joining the tables instead of using a comma between table names in get()\n$this->db->from('comments');\n$this->db->join('users', 'users.user_id = comments.submittedby_id');\n$this->db->join('sections', 'sections.id = comments.section_id');\n\n$query = $this->db->get('', 10); // The first parameter is left empty because it's already defined in from()