function save() {\n    // ...\n\n    try {\n        // ...\n\n        $lastid = parent::execSql2($query);\n\n        if($this->id == 0) {\n            $this->id = $lastid;\n        }\n\n        createRSS(); // call createRSS() after the database operation has been successfully completed\n    } catch(Exception $e) {\n        throw $e;\n    }\n}