$daddy = new Father('1', 'Foo', 'Bar');\n$first_son = $daddy->AddSon('2', 'John', '13');\necho $first_son->GetFatherJob(); // outputs "Bar"