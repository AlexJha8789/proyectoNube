
package pe.com.cibertec.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    
    private static final long serialVersionUID = 1L ;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCustomer;
    
    @NotEmpty
    private String name;
    
    private  String phone;
    
    @NotEmpty
    @Email
    private String email;
    
}
