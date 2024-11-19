package com.huang.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class submit01Controller {

    @PostMapping("/submit01")
    public Response submit(@RequestBody RequestData data) {
        List<String> interests = data.getInterests();

        String firstElement = interests.get(0);
        System.out.println(firstElement);
		return null;
        // 处理数据
//      return new Response("success", interests);
        
    }

    public static class RequestData {
        private List<String> interests;

        // Getters and setters
        public List<String> getInterests() {
            return interests;
        }

        public void setInterests(List<String> interests) {
            this.interests = interests;
        }
    }

    public static class Response {
        private String status;
        private List<String> interests;

        public Response(String status, List<String> interests) {
            this.status = status;
            this.interests = interests;
        }

        // Getters
        public String getStatus() {
            return status;
        }

        public List<String> getInterests() {
            return interests;
        }
    }
}
