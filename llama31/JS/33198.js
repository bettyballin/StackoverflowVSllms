var subjectId = $(subject).attr('subjectId');\nvar subjectName = $(subject).attr('subjectName');\n\nvar table = $("<table id='invitations' class='invitations' width='100%'></table>");\nvar tbody = $("<tbody></tbody>");\n\n$(subject).find('group').each(function() {\n  var groupId = $(this).attr('groupId');\n  var groupName = $(this).attr('groupName');\n  var ownerId = $(this).attr('ownerId');\n  var owner = findStudentNameById(subjectId, ownerId);\n\n  var tr1 = $("<tr></tr>");\n  tr1.append("<td width='55px'><img src='images/gplg.png' /></td>");\n  tr1.append("<td>" + subjectId + " <span class='subjectName'>" + subjectName + '</span> <br /> '  + groupId + " - <span class='group'>" + groupName + "</span><br /> Created By "  + owner + "</td>");\n\n  var tr2 = $("<tr></tr>");\n  tr2.append("<td width='55px'></td>");\n  tr2.append("<td><img class='accept' src='images/accept.png' /><img class='decline' src='images/decline.png' /> </td>");\n\n  tbody.append(tr1).append(tr2);\n});\n\ntable.append(tbody);