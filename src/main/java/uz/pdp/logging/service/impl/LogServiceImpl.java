package uz.pdp.logging.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import uz.pdp.logging.service.LogService;

@Service
public class LogServiceImpl implements LogService {
    private static final Logger log = LoggerFactory.getLogger(LogServiceImpl.class);

    @Override
    public void logInfo(String logPath, String message) {
        try {
            MDC.put("logpath", logPath);
            log.info(message);
        } finally {
            MDC.remove("logPath");
        }
    }
}
