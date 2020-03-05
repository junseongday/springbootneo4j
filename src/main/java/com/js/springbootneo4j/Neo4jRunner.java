package com.js.springbootneo4j;

import com.js.springbootneo4j.account.Account;
import com.js.springbootneo4j.account.AccountRepository;
import com.js.springbootneo4j.account.Role;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Neo4jRunner implements ApplicationRunner {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUserName("jh");
        account.setEmail("jh@mail.com");

        Role role = new Role();
        role.setName("admin");

        account.getRole().add(role);

//        Session session = sessionFactory.openSession();
//        session.save(account);
//        sessionFactory.close();
        accountRepository.save(account);
    }
}
