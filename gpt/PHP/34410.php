$Stmt->bind_result(\n    $this->_firstName,\n    $this->_lastName,\n    $this->_BillToAddress->address1,\n    $this->_BillToAddress->address2,\n    $this->_BillToAddress->city,\n    $this->_BillToAddress->state,\n    $this->_BillToAddress->zip,\n    $this->_BillToAddress->country,\n    $this->_email,\n    $this->_status,\n    $this->_primaryPhone,\n    $this->_mobilePhone\n);