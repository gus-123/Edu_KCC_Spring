package kosa.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class WriteService implements Service {
   
   @Autowired  //데이터 타입으 기준으로 Spring Container에 있는 객체를 가져온다. (Dao에 대해)
   @Qualifier("mySQLDao")  //두개 쓸때 강제 지정(앞에 글자가 소문자로 자동으로 변환 되서 호출)
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

   public void insertService() {  // 핵심관심 사항
      System.out.println("WriteService insertService() 호출");
      dao.insertBoard();
   }

}
