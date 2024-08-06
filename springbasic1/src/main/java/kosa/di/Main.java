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
//      //�ֹ� - springContainer �� ����
//      BeanFactory factory = 
//            new GenericXmlApplicationContext(resource);
	   
// �ּ�2	   
//	  ApplicationContext factory =
//			  new AnnotationConfigApplicationContext(Factory.class);
	   
//	  Service service = (Service)factory.getBean("writeService2");
	   
	  // �ֹ��� ��� 
	  String configuration[] = {
			  "applicationContext.xml",
			  "commonConcern.xml"
	  };
	  
	  // �ֹ����� �̿��Ͽ� spring container�� bean�� ����
	  ApplicationContext factory = 
			  new ClassPathXmlApplicationContext(configuration);
	  
      
      //writeService �������� (�ּ�1�� 3���� ��)
      //Service service = (Service)factory.getBean("writeService");
      //service.insertService();
	  
	  Kosa kosa = (Kosa)factory.getBean("kosaService");
	  //kosa.insertService();
	  kosa.list();
   }
}
