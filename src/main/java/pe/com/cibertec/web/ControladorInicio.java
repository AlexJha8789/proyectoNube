
package pe.com.cibertec.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.cibertec.domain.Customer;
import pe.com.cibertec.servicio.CustomerService;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    
    private CustomerService customerService;
    
  
    
    @GetMapping("/")
    public String inicio(Model model ){
   
        var customers = customerService.listarCustomers();
       
        log.info("ejecutando el controlador spring MVC");

        model.addAttribute("customers" , customers) ;



            return "index";
    }
    
   
    
    @GetMapping("/agregar")
    public String agregar(Customer customer){
    
    return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Customer customer){
        customerService.guardar(customer);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idCustomer}")
    public String editar(Customer customer,Model model){
        customer=customerService.encontrarCustomer(customer);
        model.addAttribute("customer",customer);
    
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idCustomer}")
    public String eliminar(Customer customer){
        customerService.eliminar(customer);
        return "redirect:/";
    }
    
}
