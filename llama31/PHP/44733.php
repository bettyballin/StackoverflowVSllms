$search_dept = $_POST['search_dept'];\n\n$conn = odbc_connect($odbc_name, $user_name, $pass_wd);\n\nif ($conn) {\n    // Notice the use of a parameter ? instead of directly inserting $search_dept\n    $query = "SELECT person.* \n              FROM department \n              JOIN person \n              ON department.department_id = person.department_id \n              WHERE department.dept_name = ?";\n\n    if($stmt = odbc_prepare($conn, $query)) {\n        // Bind the parameter securely\n        if(odbc_execute($stmt, array($search_dept))) {\n            echo '..stuff';\n            while ($row = odbc_fetch_array($stmt)) {\n                // Echo your stuff here\n                // echo $row['name'] . "\n";\n            }\n            echo '...stuff';\n        } else {\n            echo 'Executing the query was unsuccessful';\n        }\n    } else {\n        echo 'Preparing the query was unsuccessful';\n    }\n} else {\n    echo 'Unable to connect to database';\n}