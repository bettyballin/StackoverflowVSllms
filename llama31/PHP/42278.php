// Store only the ID in the session array\n$_SESSION['member_id'] = $member_id;\n\n// Fetch the member data on each request\n$member_data = $db->query("SELECT * FROM members WHERE id = ?", array($_SESSION['member_id']));