var form = $('yourFormId');\nvar jsonData = Object.toJSON(Form.serialize(form, true));\ndocument.cookie = 'form_data=' + encodeURIComponent(jsonData) + '; expires=Fri, 31 Dec 9999 23:59:59 GMT;';