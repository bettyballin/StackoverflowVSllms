function testPost() {\n     dojo.xhrPost({\n       url: 'dr_tm_w_0120.test_post',\n       form: 'orgForm',\n       contentType: 'application/x-www-form-urlencoded; charset=UTF-8',\n       load: testPostXHRCallback,\n       error: testPostXHRError\n     });\n   }