var $items;\n\nfunction add_item($id) {\n    $this->items[$id] = new myitem($id);\n}\n\nfunction remove_item($id) {\n    if (isset($this->items[$id])) {\n        unset($this->items[$id]);\n        return true;\n    } else {    \n        return false;\n    }\n}\n\nfunction get_count() {\n    return count($this->items);\n}