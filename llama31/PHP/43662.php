public function jobdetails($id) {\n    $job = $this->Job->find('first', array('conditions' => array('Job.id' => $id)));\n    $html = '<input type="text" name="jobtitle" id="jobtitle" value="' . $job['Job']['title'] . '">';\n    $html .= '<input type="text" name="department" id="department" value="' . $job['Job']['department'] . '">';\n    return $html;\n}