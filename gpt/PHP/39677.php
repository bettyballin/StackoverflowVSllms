$handle->select()\n       ->from('user_id')\n       ->where('first_name = ?', $id)\n       ->where('last_name = ?', $lname);