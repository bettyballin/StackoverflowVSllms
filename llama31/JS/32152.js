function submitToServlet(newAction) {\n  document.userGameForm.action = newAction + "?userBeanParam=" + "${userBean.someProperty}";\n}