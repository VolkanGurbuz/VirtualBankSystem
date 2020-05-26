import com.developer.guys.Core.Utilities.Util.Util
import com.developer.guys.Entities.Person
import com.developer.guys.VerificationApplication
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = VerificationApplication.class)
class VerificationTest extends Specification {


    def "person id verification success test"() {
        given: "util and person classes initialize"
        def personVerifyUtil = new Util()
        def person = new Person("xxxx", "VOLKAN", "xxxx", "xxx")
        def personBody = personVerifyUtil.sendMessage(person)

        when:
        def isValid = personVerifyUtil.isValid(personBody)
        //should be true with the right person information
        then:
        isValid == false


    }


    def "person id verification unsuccess test"() {
        given: "util and person classes initialize"
        def personVerifyUtil = new Util()
        def person = new Person("454646", "VOLKAN", "GÜRBÜZ", "34324")
        def personBody = personVerifyUtil.sendMessage(person)

        when:
        def isValid = personVerifyUtil.isValid(personBody)

        then:
        isValid == false

    }

}
