foreach($query->result() as $content) {\n    $item = json_decode(json_encode($this->{'mod_'.$content->type}->get($content->id)), true);\n    $items[] = $item;\n}