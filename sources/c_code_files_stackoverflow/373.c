pp
#include <cppunit/extensions/HelperMacros.h>
#include <cppunit/ui/text/TestRunner.h>

// Assuming Object is defined in object.h
#include "object.h"

class TestObject : public CPPUNIT_NS::TestCase
{
  CPPUNIT_TEST_SUITE(TestObject);
  CPPUNIT_TEST(testObjectIsReady);
  CPPUNIT_TEST_SUITE_END();

public:
  void setUp(void) {}
  void tearDown(void) {} 

protected:
  void testObjectIsReady(void)
  { 
     Object *theObject = GetObject();

     CPPUNIT_ASSERT_MESSAGE("check pointer is not null", theObject != NULL);

     //--- now you can play with your object without dereferencing a NULL pointer
     CPPUNIT_ASSERT_MESSAGE("check objet is ready", theObject->isReady());
  }
};

CPPUNIT_TEST_SUITE_REGISTRATION(TestObject);

int main() {
  CppUnit::TextUi::TestRunner runner;
  CppUnit::TestFactoryRegistry &registry = CppUnit::TestFactoryRegistry::getRegistry();
  runner.addTest(registry.makeTest());
  bool wasSuccessful = runner.run("", false);
  return wasSuccessful ? 0 : 1;
}