gcroot<SomeObject^> obj;\nobj = gcnew SomeObject();\nm_anotherObj = obj->GetObj();\n// No need to call AddRef or Release on m_anotherObj