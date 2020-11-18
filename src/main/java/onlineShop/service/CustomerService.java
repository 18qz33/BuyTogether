package onlineShop.service;

import onlineShop.dao.CustomerDao;
import onlineShop.entity.Cart;
import onlineShop.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired // find instance of CustomerDao and inject it
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        // set the user's isEnabled as true
        customer.getUser().setEnabled(true);

        // set relations between customer and cart
        Cart cart = new Cart();
        customer.setCart(cart);

        // put customer into the customerDao
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerByUserName(String userName) {
        return customerDao.getCustomerByUserName(userName);
    }
}
