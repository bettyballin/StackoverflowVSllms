$form = new MyForm();\n$form->setInputValues(['name' => 'John', 'email' => 'john@example.com']);\n$form->submit();\n$this->assertEquals('Success message', $form->getSuccessMessage());