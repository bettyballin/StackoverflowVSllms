with createobject("adodb.command")\n    .activeConnection = application("connectionstring")\n    .commandText = "select * from sometable where id=?"\n    set rs = .execute( ,array(123))\nend with