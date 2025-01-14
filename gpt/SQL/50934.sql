CREATE OR REPLACE FORCE VIEW TMSCODE.vCountEventsData (EV_ID_NUMBER, SI_ID, EV_YEAR, EV_INS_DATE, EV_REM_DATE, EV_AADT_TOT, EV_AADT_DIR1, EV_AADT_DIR2, EV_REPORT, DIRECTION, CNAME, STATION_DESC) AS \nSELECT\nTMSCODE.STC_EVENTS.EV_ID_NUMBER,\nTMSCODE.STC_EVENTS.SI_ID,\nTMSCODE.STC_EVENTS.EV_YEAR,\nTMSCODE.STC_EVENTS.EV_INS_DATE,\nTMSCODE.STC_EVENTS.EV_REM_DATE,\nTMSCODE.STC_EVENTS.EV_AADT_TOT,\nTMSCODE.STC_EVENTS.EV_AADT_DIR1,\nTMSCODE.STC_EVENTS.EV_AADT_DIR2,\nTMSCODE.STC_EVENTS.EV_REPORT,\nTMSCODE.D_DIRECTION.DIRECTION,\nTMSCODE.D_CONSULTANT.CNAME,\nTMSCODE.D_STATION_TYPE.STATION_DESC\nFROM\nTMSCODE.STC_EVENTS\nINNER JOIN TMSCODE.D_DIRECTION ON TMSCODE.STC_EVENTS.EV_DIR = TMSCODE.D_DIRECTION.ID\nINNER JOIN TMSCODE.D_CONSULTANT ON TMSCODE.STC_EVENTS.EV_CONS = TMSCODE.D_CONSULTANT.ID\nINNER JOIN TMSCODE.D_STATION_TYPE ON TMSCODE.STC_EVENTS.EV_STATION_TYPE = TMSCODE.D_STATION_TYPE.ID\nWITH READ ONLY;