<%\nDim currentDate, yearPart, monthPart, dayPart, hourPart, minutePart, secondPart\n\ncurrentDate = Now()\nyearPart = Year(currentDate)\nmonthPart = Right("0" & Month(currentDate), 2)\ndayPart = Right("0" & Day(currentDate), 2)\nhourPart = Right("0" & Hour(currentDate), 2)\nminutePart = Right("0" & Minute(currentDate), 2)\nsecondPart = Right("0" & Second(currentDate), 2)\n\n' Format as yyyy-mm-dd hh:mm:ss\nDim formattedDate\nformattedDate = yearPart & "-" & monthPart & "-" & dayPart & " " & hourPart & ":" & minutePart & ":" & secondPart\n\nResponse.Write("Insert Into MyTable (ThisDate) Values ('" & formattedDate & "')")\n%>