CREATE TABLE QUESTIONS (\n  ID NUMBER PRIMARY KEY,\n  TEXT VARCHAR2(255) NOT NULL,\n  TYPE VARCHAR2(20) CHECK(TYPE IN ('ROOT', 'BRANCH', 'LEAF'))\n);\n\nCREATE TABLE ANSWERS (\n  ID NUMBER PRIMARY KEY,\n  QUESTION_ID NUMBER NOT NULL,\n  TEXT VARCHAR2(255) NOT NULL,\n  FOREIGN KEY (QUESTION_ID) REFERENCES QUESTIONS(ID)\n);\n\nCREATE TABLE QUESTION_LINKS (\n  ID NUMBER PRIMARY KEY,\n  SOURCE_QUESTION_ID NUMBER NOT NULL,\n  ANSWER_ID NUMBER NOT NULL,\n  TARGET_QUESTION_ID NUMBER NOT NULL,\n  FOREIGN KEY (SOURCE_QUESTION_ID) REFERENCES QUESTIONS(ID),\n  FOREIGN KEY (ANSWER_ID) REFERENCES ANSWERS(ID),\n  FOREIGN KEY (TARGET_QUESTION_ID) REFERENCES QUESTIONS(ID)\n);