package kosa.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
   public static void main(String[] args) {

//      Resource resource = new ClassPathResource("applicationContext.xml");
//      //주방 - springContainer 빈 집합
//      BeanFactory factory = 
//            new GenericXmlApplicationContext(resource);
	   
// 주석2	   
//	  ApplicationContext factory =
//			  new AnnotationConfigApplicationContext(Factory.class);
	   
//	  Service service = (Service)factory.getBean("writeService2");
	   
	  // 주문서 등록 
	  String configuration[] = {
			  "applicationContext.xml",
			  "commonConcern.xml"
	  };
	  
	  // 주문서를 이용하여 spring container에 bean을 주입
	  ApplicationContext factory = 
			  new ClassPathXmlApplicationContext(configuration);
	  
      
      //writeService 가져오기 (주석1과 3번에 씀)
      //Service service = (Service)factory.getBean("writeService");
      //service.insertService();
	  
	  Kosa kosa = (Kosa)factory.getBean("kosaService");
	  //kosa.insertService();
	  kosa.list();
   }
}
