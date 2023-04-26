package gb.app.modules.user

import gb.app.config.Constants
import gb.app.domain.AppUser
import gb.app.modules.email.EmailService
import gb.app.modules.user.dto.UserSignUpDTO
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification

class AppUserServiceSpec extends Specification {

    UserRepository userRepository
    LiteUserRepository liteUserRepository
    PasswordEncoder passwordEncoder
    AuthorityService authorityService
    EmailService emailService

    UserService userService

    def setup() {
        userRepository = Mock()
        passwordEncoder = NoOpPasswordEncoder.getInstance()
        authorityService = Mock()
        emailService = Mock()
        userService = new UserService(userRepository, passwordEncoder, authorityService, emailService, liteUserRepository)
    }

    def 'create user'() {
        given:
        def toCreate = new UserSignUpDTO(uniqueId: 'U01', pwdPlaintext: 'pass', lastName: 'last1', firstName: 'first', email: 'gg@email')

        when:
        AppUser user = userService.create(toCreate)

        then:
        user.password == toCreate.pwdPlaintext //noop encoder
        user.uniqueId == toCreate.uniqueId
        user.email == toCreate.email
        1 * authorityService.findByNameIn(Constants.ROLE_USER)
        1 * userRepository.save(_)
        1 * emailService.sendEmail(_)
        0 * _
    }
}
