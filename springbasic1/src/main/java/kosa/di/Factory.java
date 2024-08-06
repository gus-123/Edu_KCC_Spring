package kosa.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration - xml ���� �ڹ� �����̶�°��� �˷���.(�޼ҵ���� ��ü�̸�)
public class Factory {
	//�ֹ����� �ڹ� ���Ϸ� �ϰ���(xml ���)
	@Bean
	//��ü ����
	public Dao oracleDao() {
		return new OracleDao();  // �޼ҵ���� id ������ �� (oracleDao)
	}
	
	@Bean
	public Service writeService2() {
		return new WriteService();
	}
}
