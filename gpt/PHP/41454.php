<?php\nfunction executeQuery($conn, $sql) {\n    $result = mysqli_query($conn, $sql);\n    \n    if (!$result) {\n        if (isset($_SESSION['auto_id']) && $_SESSION['auto_id'] == 1) {\n            die("<span style='FONT-SIZE:11px; COLOR: #000000; font-family: tahoma;'><center>An Internal Error has Occured. Please report following error to error@friendproject.com<br><br>" . $sql . "<br><br>" . mysqli_error($conn) . "</center></FONT>");\n        } else {\n            die("<span style='FONT-SIZE:11px; COLOR: #000000; font-family: tahoma;'><center>An Internal Error has Occured. The error has been recorded</center></FONT>");\n        }\n    }\n    \n    return $result;\n}\n?>