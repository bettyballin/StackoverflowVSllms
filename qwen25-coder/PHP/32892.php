$result = $handle->select()\n                ->from('store_details', array('store_name')) // Specify columns here\n                ->where('store_details.store_id = ?', $id);