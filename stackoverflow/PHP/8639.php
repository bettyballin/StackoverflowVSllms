if (isset($headers['If-Modified-Since']) && (strtotime($headers['If-Modified-Since']) >= $file_time)) {