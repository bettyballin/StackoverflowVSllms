-- Step 4: Update the running balance for all subsequent transactions\nUPDATE transactions\nSET running_balance = running_balance + <NEW_AMOUNT>\nWHERE date > <NEW_DATE>\n   OR (date = <NEW_DATE> AND id > <NEW_TRANSACTION_ID>);