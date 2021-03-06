package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

public class StudentRegisterTest {
    StudentRegister register;

    @Before
    public void setupTest()
    {
        System.out.println("A new test is starting.");
        
        register = new StudentRegister();
        try{
        	register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "gayan", "chamara"));
            register.addStudent(new Student(6, "kumara", "nimal"));
        }catch(Exception ex){
        	Assert.fail("Adding student failed");
        }
        
        
    }

    @After
    public void finishTest()
    {
        System.out.println("Test finished");
    }

    @BeforeClass
    public  static void beforeClass()
    {
        System.out.println("Evaluating test cases in StudentRegisterTest.java");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("All tests are done");
    }

   @Test
    public void testAddStudent()
   {
       register = new StudentRegister();
       try
       {
           register.addStudent(new Student(3, "nimal", "kumara"));
           register.addStudent(new Student(4, "fawzan", "mohomad"));
       }
       catch (Exception ex)
       {
           Assert.fail("Adding student failed");
       }
       System.out.println("Testing add student method");

       Student student = register.findStudent(3);
       Assert.assertEquals("Student Id is wrong",3,student.getId());
   }

   @Test
    public void testAddStudentTwice()
   {
       // Implement your test code here. Adding a student with same registration number twice should generate an exception.
       //sAssert.fail("Test case is not yet implemented for adding student twice. So it is set to fail always");
       register = new StudentRegister();
       try{
    	   register.addStudent(new Student(7, "kamal", "hassan"));
           register.addStudent(new Student(7, "amal", "bandara"));
           Assert.fail("same re no twice.");
       }catch (Exception ex){
    	   
    	   
       }
   }

    @Test
    public void testRemoveStudent()
    {       
        register.removeStudent(1);
        Student student = register.findStudent(1);
        Assert.assertNull("student was not removed",student);
    }

    @Test
    public void testGetRegNumbers()
    {
        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(5);
        expected.add(6);
        Assert.assertTrue(numbers.equals(expected));
    }
    @Test
    public void testFindStudentByName(){
    	
    	ArrayList<Student> students = register.findStudentsByName("nimal"); 
    	Assert.assertNotNull("student was found",students.get(1));
    	
    }
    @Test
    public void testReset(){
    	
    	register.reset();
    	ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
    	
    	Assert.assertTrue("Reset done successfully", numbers.size() == 0 );
    }
    
    
}
 