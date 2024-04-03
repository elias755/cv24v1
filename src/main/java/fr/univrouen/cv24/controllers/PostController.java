package fr.univrouen.cv24.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
	
	@RequestMapping(value = "/testpost", method = RequestMethod.POST,
			consumes = "application/xml")
	public String postTest(@RequestBody String flux) {
		return ("<result><response>Message reçu : </response>"
			+ flux + "</result>");
	}
	
}
