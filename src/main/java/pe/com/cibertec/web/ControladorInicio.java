
package pe.com.cibertec.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.cibertec.domain.Customer;
import pe.com.cibertec.servicio.CustomerService;

@RestController
@RequestMapping("/api")
public class ControladorInicio {

    @Autowired

    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        var customers = customerService.listarCustomers();
        return customers;
    }

    @PostMapping("/customers")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.guardar(customer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        Customer customer = new Customer();
        customer.setIdCustomer(id);
        customerService.eliminar(customer);
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerId(@PathVariable("id") Long id) {
        Customer customer = new Customer();
        customer.setIdCustomer(id);
        return customerService.encontrarCustomer(customer);
    }

    @PutMapping("/updateCustomer/{id}")
    public Customer update(@PathVariable("id") Long id, @RequestBody Customer customer) {
        return customerService.actualizar(customer);
    }

}

