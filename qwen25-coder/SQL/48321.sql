set feedback off\nSET NEWPAGE NONE\nset HEADING Off\nset pagesize 0\nset linesize 125\nSET TRIMSPOOL ON\nSET TRIMOUT ON -- added this line\nSET TRIMSPOOL ON -- ensure trimming in spool file as well\nset termout on\nspool /export/home/43276826/Rep_Tran_oracle_$DATE_FILE.txt\n\nselect RecordID||','||C_S||','||P_R||','||AccountingDate||','||SettlementDate||','||\n       SecDescription||','||ISIN||','||MessageRef||','||Amount||','||\n       Department||','||AssignedTo||','||LastUpdate||','||\n       CashAmount||','||CashAmountUSD||','||LastNoteText||','||\n       LastNoteUser||','||CashCurrency||','||BIMASNumber||','||\n       RelatedReference||','||SenderToRec||','||OpType||','||\n       OriginalISIN \nfrom HSBC_ALL_OI_T;\n\nspool off