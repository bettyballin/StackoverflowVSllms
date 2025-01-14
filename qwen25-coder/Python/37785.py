import xml.etree.ElementTree as ET\n\nxml_data = '''<root title="الصفحة الرئيسية">\n   <item title="الصفحة الرئيسة" itemuri="tcm:8-29-4" ShowInNav="True" type="sg" pageuri="tcm:8-10592-64" sLink="/ara/index.aspx">\n      <item title="من نحن" itemuri="tcm:8-779-4" ShowInNav="True" type="sg" pageuri="tcm:8-9934-64" navorder="00500" sLink="/ara/about/index.aspx">\n      </item>\n      <item title="برامجنا" itemuri="tcm:8-817-4" ShowInNav="True" type="sg" pageuri="tcm:8-10112-64" navorder="00100" sLink="/ara/courses/language-study-abroad.aspx">\n      </item>\n      <item title="مدارسنا" itemuri="tcm:8-824-4" ShowInNav="True" type="sg" pageuri="tcm:8-10162-64" navorder="00300" sLink="/ara/schools/english-language.aspx"> \n      </item> \n   </item>\n</root>'''\n\ndef find_max_navorder(xml_string):\n    root = ET.fromstring(xml_string)\n    max_navorder = -1\n    for item in root.findall('.//item[@navorder]'):\n        navorder_value = int(item.get('navorder'))\n        if navorder_value > max_navorder:\n            max_navorder = navorder_value\n    return max_navorder\n\nmax_order = find_max_navorder(xml_data)\nprint("Maximum navorder value is:", max_order)