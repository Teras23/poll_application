package com.eucolus.poll.controllers.api;

import com.eucolus.poll.entities.Request;
import com.eucolus.poll.repositories.RequestRepository;
import com.eucolus.poll.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping(path="/api/requests")
public class RequestApiController {
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private RequestService requestService;

    @GetMapping("/dates")
    public @ResponseBody List<Object> getDateHist() {
        return requestRepository.getDateHist();
    }

    @GetMapping("/browsers")
    public @ResponseBody List<Object[]> getBrowsers() {
        return requestService.getBrowsers();
    }

    @GetMapping("/oss")
    public @ResponseBody List<Object> getOSs() {
        return requestRepository.getOSRequestsCount();
    }

}
