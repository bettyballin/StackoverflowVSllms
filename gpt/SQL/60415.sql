CREATE XML INDEX SXI_Contacts_Refno\nON Contacts(xmlvaluesn)\nUSING XML INDEX PXML_Contacts_xmlvaluesn\nFOR PATH ('/contact/refno');