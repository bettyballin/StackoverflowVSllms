$weeks = (int) $_POST['weeks'];\n$endDate = new DateTime();\n$endDate->add(new DateInterval("P{$weeks}W"));\n$mysqlDate = $endDate->format('Y-m-d H:i:s');