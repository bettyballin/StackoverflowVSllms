SELECT\n  ...\nFROM mc_current_view a\nJOIN account_master am ON a.account_no = am.account_no\nJOIN account_master am_loan ON am.account_no = am_loan.parent_account_no\nJOIN ml_client_account mca ON a.account_no = mca.account_no