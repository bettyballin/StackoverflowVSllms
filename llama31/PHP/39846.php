public function row2Partner($row){\n  if (is_object($row)) {\n    echo $row->PartnerID;\n  } else {\n    // Handle the case where $row is not an object\n    echo "Error: Row is not an object.";\n  }\n}\n\npublic function main(){\n  $query = "SELECT PartnerID, PartnerName FROM Partner";\n  $result = mysql_query($query);\n  $row = mysql_fetch_object($result);\n  // Now, $row is clearly an object within the scope of main()\n  $this->row2Partner($row);\n}