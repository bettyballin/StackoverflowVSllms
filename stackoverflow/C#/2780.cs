content = RegEx.Replace(content, "(?<!>)" \n   + keyword \n   + "(?!(<|\w))", "<span blah...>" + keyword + '</span>';