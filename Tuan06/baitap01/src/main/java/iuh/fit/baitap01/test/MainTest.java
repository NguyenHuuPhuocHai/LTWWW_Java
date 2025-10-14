package iuh.fit.baitap01.test;

import iuh.fit.baitap01.model.SinhVien;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        SinhVien sv = (SinhVien) context.getBean("sinhVien");
        System.out.println(sv);
    }
}
