package testRunner;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import tests.ApplyMethodTests;
import tests.SkillAnxietyTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({SkillAnxietyTests.class, ApplyMethodTests.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnit4Runner {

}
