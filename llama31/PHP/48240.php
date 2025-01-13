public function insertAt($index, $person) {\n    if ($index < 0 || $index > count($this->items)) {\n        throw new OutOfRangeException("Index out of range");\n    }\n    \n    array_splice($this->items, $index, 0, [$person]);\n    \n    // Update the $itemsHash array\n    $this->internalRegisteredHashList = [];\n    foreach ($this->items as $i => $item) {\n        $this->internalRegisteredHashList[$item->getHash()] = $i;\n    }\n}