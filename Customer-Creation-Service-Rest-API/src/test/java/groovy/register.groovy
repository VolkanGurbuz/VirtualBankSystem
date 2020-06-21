import com.developer.guys.Application
import com.developer.guys.Business.Abstract.ICustomerService
import com.developer.guys.Business.Concrete.CustomerManager
import com.developer.guys.Core.Utilities.Result.Result
import com.developer.guys.DataAccess.Abstract.ICustomerDal
import com.developer.guys.Entity.Concrete.Customer
import com.developer.guys.RestApi.CustomerController
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.ui.Model
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.anyLong
import static org.mockito.Mockito.when
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest(classes = Application.class)
class VerificationTest extends Specification {


    @Mock
    ICustomerService _customerService;

    @InjectMocks
    CustomerController customerController;

    @Mock
    Model model;
    MockMvc mockMvc;

    def setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }


    def "adding customer test"() {

        given: "create customer"
        Customer customer = new Customer()
        customer.setName("volkan")
        customer.setEmail("volkagurbuz16@gmail.com")
        customer.setSurName("gurbuz")
        customer.setPassword("deneme")

        println("Status ")

        when:
        when(customerController.Add(customer, model)).thenReturn(model)

        then:


        mockMvc.perform(
                post("/api/customers/register")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())


    }


}