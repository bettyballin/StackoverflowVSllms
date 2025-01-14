-- Creating a primary XML index\n   CREATE PRIMARY XML INDEX PXML_ContactInfo ON Contacts(xmlvaluesn);\n\n   -- Creating a secondary selective XML index on the Ref element\n   CREATE SELECTIVE XML INDEX SXIX_PersonalData\n   ON Contacts(xmlvaluesn)\n   FOR \n       (\n           ref AS XQuery '(/contact/ref)[1]' SINGLE,\n           special AS XQuery '(/contact/special)[1]'\n       )