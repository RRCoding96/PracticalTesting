package sample.cafekiosk.spring;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import sample.cafekiosk.spring.client.mail.MailSendClient;

@ActiveProfiles("test")
@SpringBootTest
public abstract class IntegrationTestSupport {

    // 여기서 MockBean을 해줘야 Mock을 위해 새롭게 서버가 뜨지 않는다.
    @MockBean
    protected MailSendClient mailSendClient;

}
