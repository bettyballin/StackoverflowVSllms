function submitAction()\n{\n    document.frmProduct.submit = document.frmProduct.submit.bind(document.frmProduct);\n    document.frmProduct.submit();\n}