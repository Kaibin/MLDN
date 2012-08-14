package scut.labtalk;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import scut.labtalk.domain.Admin;
import scut.labtalk.domain.Answer;
import scut.labtalk.domain.Gender;
import scut.labtalk.domain.Item;
import scut.labtalk.domain.Question;
import scut.labtalk.domain.Subitem;
import scut.labtalk.domain.User;

public class SimpleTest {

	@Before
	public void setupTestDataInTransaction() {

	}

	@Test
	public void testSave() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("labtalk");
		EntityManager em = factory.createEntityManager();		
		
		//Create admin
		em.getTransaction().begin();			
		Admin admin = new Admin("gunroseman","gunroseman");
		em.persist(admin);
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}
	
	@Test 
	public void test2(){
		
		//Create user
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("labtalk");
		EntityManager em = factory.createEntityManager();	
		em.getTransaction().begin();			
		User tester = new User(Gender.MALE, "test@gmail.com", "I love you", "tester", "kaibin", "thank you", "gunroseman", 8, 10);
		em.persist(tester);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Item item1 = new Item("Signal Processing",1);
		Subitem subitem11 = new Subitem("Image Processing", 1);
		Subitem subitem12 = new Subitem("UnderWater Signal", 2);
		item1.addSubitem(subitem11);
		item1.addSubitem(subitem12);
		em.persist(item1);//级联保存
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Item item2 = new Item("Communication",1);
		Subitem subitem21 = new Subitem("Network communication", 1);
		Subitem subitem22 = new Subitem("Wireless communication", 2);
		item2.addSubitem(subitem21);
		item2.addSubitem(subitem22);
		em.persist(item2);//级联保存
		em.getTransaction().commit();
		em.getTransaction().begin();
		Question ques1 = new Question("What's Image Processing", " Do you know what's Image Processing", item1.getItemid(), subitem11.getSubid(), tester.getUserid(), "grade", 10, Question.SOLVED, new Date(), 10, Question.ACCEPT, Question.COMMENT);
		Answer ans11 = new Answer("I know what's Image Processing", tester.getUserid(), "grade", new Date(), Answer.ACCEPT);
		ques1.addAnswer(ans11);
		em.persist(ques1);//级联保存
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Question ques2 = new Question("What's Network communication", " Do you know what's Network communication", item2.getItemid(), subitem21.getSubid(), tester.getUserid(), "grade", 10, Question.UNSOLVED, new Date(), 10, Question.NOACCEPT, Question.NOCOMMENT);
		Answer ans21 = new Answer("I know what's Network communication", tester.getUserid(), "grade", new Date(), Answer.NOACCEPT);
		ques2.addAnswer(ans21);
		em.persist(ques2);//级联保存
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}
	
	@Test
	public void testQuestion(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("labtalk");
		EntityManager em = factory.createEntityManager();	
		em.getTransaction().begin();	
		
		Question que = new Question();
		que.setTitle("title");
		que.setContent("content");
		que.setGrade(scut.labtalk.util.IntegralGrade.getInstance().getGradeInfo(5));
		que.setUserid("userid");
		que.setOfferscore(10);
		que.setQuestiontime(new Date());
		que.setStatus(1);
		que.setAcceptflag(2);
		que.setCommenflag(0);
		que.setClickcount(10);
		
		em.persist(que);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
