SET SERVEROUTPUT ON\nDECLARE\n  v_ename EMP.FIRST_NAME%TYPE;\n  v_salary EMP.SALARY%TYPE;\n  CURSOR c_emp IS SELECT first_name, salary FROM emp;\nBEGIN\n  OPEN c_emp;\n  FETCH c_emp INTO v_ename, v_salary;\n  DBMS_OUTPUT.PUT_LINE('Employee Details ' || v_ename || ' ' || v_salary); -- Missing semicolon\n\n  FETCH c_emp INTO v_ename, v_salary;\n  DBMS_OUTPUT.PUT_LINE('Employee Details ' || v_ename || ' ' || v_salary); -- Missing semicolon\n\n  CLOSE c_emp;\nEND;\n/