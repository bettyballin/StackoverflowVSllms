// Corrected search queries\n$this->view->photos = $index->find('"lorem ipsum" AND type:photo');\n$this->view->videos = $index->find('"lorem ipsum" AND type:video');