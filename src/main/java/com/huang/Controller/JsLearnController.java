package com.huang.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.huang.Model.Student;

@RestController
@RequestMapping("/api")
public class JsLearnController {

	    @GetMapping("/weather")
	    public List<Map<String, String>> getWeather() {
	        List<Map<String, String>> weather = new ArrayList<>();
	        weather.add(Map.of("value", "", "text", "選択してください"));
	        weather.add(Map.of("value", "sunny", "text", "晴れ"));
	        weather.add(Map.of("value", "rainy", "text", "雨"));
	        weather.add(Map.of("value", "snowing", "text", "雪"));
	        weather.add(Map.of("value", "overcast", "text", "曇り"));
	        return weather;      
	    }	    
	}



