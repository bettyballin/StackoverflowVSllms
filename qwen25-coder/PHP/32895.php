$result = $handle->select()\n                ->from('store_details')\n                ->columns(array('store_name')) // Use columns here instead\n                ->where('store_details.store_id = ?', $id);