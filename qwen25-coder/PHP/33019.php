include("../Includes/FusionCharts.php");\n\n// Create an XML data document in a string variable\n$strXML  = "<graph caption='Monthly Unit Sales' xAxisName='Month' yAxisName='Units'";\n$strXML .= " decimalPrecision='0' formatNumberScale='0'>";\n$strXML .= "<set name='Jan' value='462' color='AFD8F8' />";\n$strXML .= "<set name='Feb' value='857' color='F6BD0F' />";\n$strXML .= "<set name='Mar' value='671' color='8BBA00' />";\n$strXML .= "<set name='Apr' value='494' color='FF8E46' />";\n$strXML .= "<set name='May' value='761' color='008E8E' />";\n$strXML .= "<set name='Jun' value='960' color='D64646' />";\n$strXML .= "<set name='Jul' value='629' color='8E468E' />";\n$strXML .= "<set name='Aug' value='622' color='588526' />";\n$strXML .= "<set name='Sep' value='376' color='B3AA00' />";\n$strXML .= "<set name='Oct' value='494' color='008ED6' />";\n$strXML .= "<set name='Nov' value='761' color='9D080D' />";\n$strXML .= "<set name='Dec' value='960' color='A186BE' />";\n$strXML .= "</graph>";\n\n// Render the chart HTML and assign it to a Smarty variable\n$chartHtml = renderChartHTML("../../FusionCharts/FCF_Column3D.swf", "", $strXML, "myNext", 600, 300);\n$smarty->assign('chartdata', $chartHtml);\n\n// Display the template\n$smarty->display('your_template.tpl');