public function getSomeData($id)\n    {\n        // Set a breakpoint here\n        $result = $this->dbTable->find($id);\n        return $result;\n    }