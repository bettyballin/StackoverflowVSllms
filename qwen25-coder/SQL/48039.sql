select * \nfrom reason_for_appointment \nwhere reason_for_appointment_id in (\n    select reason_for_appointment_id \n    from appointment_reason \n    where appointment_id = 11\n)\norder by some_column; -- specify the column you want to order by