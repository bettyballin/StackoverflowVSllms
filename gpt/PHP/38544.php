function insertFormName()\n{   \n    $this->data['Form']['formname'] = $this->params['form']['formname'];\n    $this->Form->saveFormName($this->data);\n}\n\nfunction insertFieldEntry()\n{\n    $this->data['Attribute']['type'] = $this->params['form']['type'];\n    $this->data['Attribute']['sequence_no'] = $this->params['form']['sequence_no'];\n    $this->Form->saveFieldEntries($this->data);\n}