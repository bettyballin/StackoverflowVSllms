function sub_d()\n{\n  i=0;\n  while (document.checks.OGname.length > i)\n  {\n    if (document.checks.OGname[i].checked="true")\n      {\n        document.checks.OGname[i].name="newname";\n      }else{\n        i++;\n      }\n  }\n  document.checks.submit();\n}