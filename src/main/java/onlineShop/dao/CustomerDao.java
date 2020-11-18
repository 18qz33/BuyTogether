package onlineShop.dao;

import onlineShop.entity.Authorities;
import onlineShop.entity.Customer;
import onlineShop.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // can get the instances at Service
public class CustomerDao {
    @Autowired // @Autowired: inject instance
    // SessionFactory: Connect to MySQL and map object to records in DB
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmailId(customer.getUser().getEmailId());

        Session session = null;
        try {
            // start to operate at DB after getting session
            session = sessionFactory.openSession();
            // define multiple tables
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            // get and save all the operations
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // roll back to beginTransaction()
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Customer getCustomerByUserName(String userName) {
        User user = null;
        try(Session session = sessionFactory.openSession()){
            Criteria criteria = session.createCriteria(User.class);
            user = (User) criteria.add(Restrictions.eq("emailId", userName)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null) {
            return user.getCustomer();
        }
        return null;
    }

}
