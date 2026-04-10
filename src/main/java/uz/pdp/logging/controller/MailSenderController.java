package uz.pdp.logging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.logging.service.MailSenderService;

@Slf4j
@RestController
@RequestMapping("/api/mail")
@RequiredArgsConstructor
public class MailSenderController {
    private final MailSenderService mailSenderService;

    @GetMapping("/sendMessage/{username}")
    public String sendMessage(@PathVariable String username) {
        mailSenderService.sendMessage(username);
        return "Message sended successfuly";
    }
}
