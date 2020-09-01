package SOAP.SOAP;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.xmlbeans.XmlException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;

public class infoCountryServiceTest {
	
/*	@Test
	public void test() throws Exception {
	    SoapUITestCaseRunner testCaseRunner = new SoapUITestCaseRunner();
	    testCaseRunner.setProjectFile("C:\\Users\\formation\\Documents\\SquashTA-1.10.0-RELEASE-workspace\\SOAP\\src\\test\\resources\\CountryInfoService-soapui-project.xml");
	    try {
	        testCaseRunner.run();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
*/

/*	@Test
	public void JunitTest1()
	        throws XmlException, IOException, SoapUIException {
	    // Créer une nouvelle instance de WsdlProject en spécifiant le chemin absolu du projet SoapUI
	    WsdlProject project = new WsdlProject(
	            "C:\\Users\\formation\\Documents\\SquashTA-1.10.0-RELEASE-workspace\\SOAP\\src\\test\\resources\\CountryInfoService-soapui-project.xml");
	    // Récupère tous les TestSuites inclus dans le projet SoapUI
	    List<TestSuite> testSuiteList = project.getTestSuiteList();
	    // Itération sur tous les TestSuites du projet
	    for (TestSuite ts : testSuiteList) {
	        System.out.println("******Running " + ts.getName() + "***********");
	        // Récupère tous les TestCases d'une TestSuite
	        List<TestCase> testCaseList = ts.getTestCaseList();
	        // Itération sur tous les TestCases d'un TestSuite particulier
	        for (TestCase testcase : testCaseList) {
	            System.out.println("******Running " + testcase.getName() + "***********");
	            // Exécute le TestCase spécifié
	            TestRunner testCaseRunner = testcase.run(new PropertiesMap(), false);
	            // Vérifie si le TestCase s'est terminé correctement
	            // ou s'il a échoué à cause d'un échec d'assertion
	            assertEquals(TestRunner.Status.FINISHED, testCaseRunner.getStatus());
	        }
	    }
	}*/

	@RunWith(Parameterized.class)
	public static class JunitTest7 {

	    private String testCaseName;
	    private static String soapuiProjectName = "C:\\Users\\formation\\Documents\\SquashTA-1.10.0-RELEASE-workspace\\SOAP\\src\\test\\resources\\CountryInfoService-soapui-project.xml";

	    public JunitTest7(String testCaseName) {
	        this.testCaseName = testCaseName;
	    }   

	    @Parameters(name="{0}")
	    public static Collection<String[] > getTestCases() throws XmlException, IOException, SoapUIException {
	        final ArrayList<String[]>  testCases = new ArrayList<String[]>();
	        WsdlProject soapuiProject = new WsdlProject(soapuiProjectName);
	        WsdlTestSuite wsdlTestSuite = soapuiProject.getTestSuiteByName("TestSuiteCountryInfoService");
	        List<TestCase> testCaseStrings = wsdlTestSuite.getTestCaseList();

	        for (TestCase ts : testCaseStrings) {
	            if (!ts.isDisabled()) {
	                testCases.add(new String[] { ts.getName() });
	            }
	        }
	        return testCases;
	    }

	    @Test
	    public void testSoapUITestCase() throws XmlException, IOException, SoapUIException {
	        System.out.println("Nom du cas de test SoapUI : " + testCaseName);
	        assertTrue(true);
	        assertTrue(runSoapUITestCase(this.testCaseName));
	    }

	    public static boolean runSoapUITestCase(String testCase) throws XmlException, IOException, SoapUIException {
	        TestRunner.Status exitValue = TestRunner.Status.INITIALIZED;
	        WsdlProject soapuiProject = new WsdlProject(soapuiProjectName);
	        WsdlTestSuite testSuite = soapuiProject.getTestSuiteByName("TestSuiteCountryInfoService");
	        if (testSuite == null) {
	            System.err.println("runner soapUI, la suite de test est null : " + testSuite);
	            return false;
	        }
	        WsdlTestCase soapuiTestCase = testSuite.getTestCaseByName(testCase);
	        if (soapuiTestCase == null) {
	            System.err.println("runner soapUI, le cas de test est null : " + testCase);
	            return false;
	        }
	        soapuiTestCase.setDiscardOkResults(true);
	        WsdlTestCaseRunner runner = soapuiTestCase.run(new PropertiesMap(), false);
	        exitValue = runner.getStatus();

	        System.out.println("cas de test soapUI terminé ('" + testSuite + "':'" + testCase + "') : " + exitValue);
	        if (exitValue == TestRunner.Status.FINISHED) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	}

}
