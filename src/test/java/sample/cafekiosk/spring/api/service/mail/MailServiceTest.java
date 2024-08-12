package sample.cafekiosk.spring.api.service.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import sample.cafekiosk.spring.client.mail.MailSendClient;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistory;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Mockito 쓰겠다고 알려줌
class MailServiceTest {

    @Spy // 기존 빈의 특정 메소드의 동작만을 모킹할 때 활용
    private MailSendClient mailSendClient;

    @Mock // Mock으로 만들어줌
    private MailSendHistoryRepository mailSendHistoryRepository;

    @InjectMocks // MailService의 생성자를 보고 Mock을 넣어줌(DI의 역할)
    private MailService mailService;

    @DisplayName("메일 전송 테스트")
    @Test
    void sendMail() {
        // given

        // when() : @Spy가 아닌 @Mock을 테스트 할 때 사용
//        when(mailSendClient.sendEmail(anyString(), anyString(), anyString(), anyString()))
//            .thenReturn(true);

        // do...() : 실제 객체의 것을 mocking
        // sendEmail만 stubbing되고, a, b, c 메소드는 실제 객체의 기능 그대로 수행됨
        doReturn(true)
            .when(mailSendClient)
            .sendEmail(anyString(), anyString(), anyString(), anyString());

        // when
        boolean result = mailService.sendMail("", "", "", "");

        // then
        assertThat(result).isTrue();
        // mailSendHistoryRepository가 몇 번 호출 됐는지? (1번)
        verify(mailSendHistoryRepository, times(1)).save(any(MailSendHistory.class));
    }

}