import com.developer.guys.Core.Utilities.Util.Util
import com.developer.guys.Entities.Person
import spock.lang.Specification


class VerificationTest extends Specification {


    def "person id verification success test"() {
        given: "util and person classes initialize"
        def personVerifyUtil = new Util()
        def person = new Person("xxxx", "VOLKAN", "xxxx", "xxx")
        def personBody = personVerifyUtil.sendMessage(person)

        when:
        def isValid = personVerifyUtil.isValid(personBody)

        then:
        isValid == true


    }


    def "person id verification unsuccess test"() {
        given: "util and person classes initialize"
        def personVerifyUtil = new Util()
        def person = new Person("454646", "VOLKAN", "GÜRBÜZ", "34324")
        def personBody = personVerifyUtil.sendMessage(person)

        when:
        def isValid = personVerifyUtil.isValid(personBody)

        then:
        isValid == true


    }


}
