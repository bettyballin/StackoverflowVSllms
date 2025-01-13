$start_date = filter_input(INPUT_POST, 'start_date', FILTER_SANITIZE_STRING);\n$end_date = filter_input(INPUT_POST, 'end_date', FILTER_SANITIZE_STRING);\n\ntry {\n    $st_dt = new DateTime($start_date);\n    $end_dt = new DateTime($end_date);\n\n    if ($end_dt > $st_dt) {\n        echo 'End date is later than start date';\n    } else {\n        echo 'End date is not later than start date';\n    }\n} catch (Exception $e) {\n    // handle the exception\n}