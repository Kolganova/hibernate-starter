package com.kolganova;

import com.kolganova.entity.Birthday;
import com.kolganova.entity.Company;
import com.kolganova.entity.PersonalInfo;
import com.kolganova.entity.User;
import com.kolganova.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

@Slf4j
public class HibernateRunner {

    public static void main(String[] args) {
        Company company = Company.builder()
                .name("Google")
                .build();
        User user = User.builder()
                .username("Irina04@gmail.com")
                .personalInfo(PersonalInfo.builder()
                        .lastName("Irinova")
                        .firstName("Irina")
                        .birthDate(new Birthday(LocalDate.of(2010, 3, 8)))
                        .build())
                .company(company)
                .build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {
                Transaction transaction = session1.beginTransaction();
                session1.persist(company);
                session1.persist(user);
                session1.getTransaction().commit();
            }
        }
    }

}
