#include <memory>\nusing namespace std;\n\nunique_ptr<Table> table = make_unique<Table>(db->query("select * from t"));