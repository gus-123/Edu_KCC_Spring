package kosa.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class WriteService implements Service {
   
   @Autowired  //������ Ÿ���� �������� Spring Container�� �ִ� ��ü�� �����´�. (Dao�� ����)
   @Qualifier("mySQLDao")  //�ΰ� ���� ���� ����(�տ� ���ڰ� �ҹ��ڷ� �ڵ����� ��ȯ �Ǽ� ȣ��)
   private Dao dao;
   
   public WriteService() {
   }
   
   public WriteService(Dao dao) {
      super();
      this.dao = dao;
   }

   public Dao getDao() {
	return dao;
   }

   public void setDao(Dao dao) {
	   this.dao = dao;
   }

   public void insertService() {  // �ٽɰ��� ����
      System.out.println("WriteService insertService() ȣ��");
      dao.insertBoard();
   }

}
