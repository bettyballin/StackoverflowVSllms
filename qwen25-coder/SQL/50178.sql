CREATE OR REPLACE PACKAGE my_package AS\n     PROCEDURE my_procedure(p_param IN VARCHAR2);\n   END my_package;\n   \n   CREATE OR REPLACE PACKAGE BODY my_package IS\n     PROCEDURE my_procedure(p_param IN VARCHAR2) IS \n     BEGIN\n       -- procedure logic\n     END my_procedure;\n   END my_package;