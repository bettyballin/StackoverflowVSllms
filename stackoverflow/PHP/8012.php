if (!preg_match('/^freetrip\s+([1-5]{5})$/i', $sms, $matches)) exit("error");\nprint_r($matches);