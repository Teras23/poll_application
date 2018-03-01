package com.eucolus.poll.Controllers.Api;

import com.eucolus.poll.Entities.Request;
import com.eucolus.poll.Repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/api/requests")
public class RequestAPIController {
    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("")
    public @ResponseBody List<Request> getAllRequests() {
        return requestRepository.findAllRequests();
    }
}
