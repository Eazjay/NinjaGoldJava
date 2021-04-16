package com.codingdojo.ninjagold;

import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	
	@RequestMapping("/")
	public String places(HttpSession session) {
		if(session.getAttribute("totalGold") == null) {
			session.setAttribute("totalGold", 0);
			session.setAttribute("activities", new ArrayList <String>());
		}
		return "ninjagold.jsp";
	}
	
	@RequestMapping(value="/processGold", method=RequestMethod.POST)
	public String processGold(@RequestParam(value="place") String place, HttpSession session) {
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("EEEE, dd MMMM Y (hh:mm a)");
		ArrayList <String> act = (ArrayList <String>) session.getAttribute("activities");
		Random rand = new Random();
		if(place.equals("farm")) {
			Integer gold = (rand.nextInt(20 - 9) + 1) + 9;
			System.out.println("Test: " + gold);
			act.add(0, "Earned " + gold + " gold from the Farm. " + dateTime.format(LocalDateTime.now()));
			session.setAttribute("activities", act);
			Integer sGold = (Integer) session.getAttribute("totalGold");
			System.out.println(sGold);
			session.setAttribute("totalGold", sGold + gold);
		}
		
		else if(place.equals("cave")){
			int gold = (rand.nextInt(10 - 4) + 1) + 4;
			act.add(0, "Earned " + gold + " gold from the Cave. " + dateTime.format(LocalDateTime.now()));
			session.setAttribute("activities", act);
			Integer sGold = (Integer) session.getAttribute("totalGold");
			System.out.println(sGold);
			session.setAttribute("totalGold", sGold + gold);
		}
		
		else if(place.equals("house")) {
			int gold = (rand.nextInt(5 - 1) + 1) + 1;
			act.add(0, "Earned " + gold + " gold from the House. " + dateTime.format(LocalDateTime.now()));
			session.setAttribute("activities", act);
			Integer sGold = (Integer) session.getAttribute("totalGold");
			System.out.println(sGold);
			session.setAttribute("totalGold", sGold + gold);
		}
		
		else if(place.equals("casino")) {
			int gold = (rand.nextInt(50 - -50) + 1) + -50;
			if(gold > 0) {
				act.add(0, "You earned " + gold + " gold from the Casino. " + dateTime.format(LocalDateTime.now()));
			}
			else if(gold < 0) {
				act.add(0, "<span class=\"red\"> You lost " + Math.abs(gold) + " gold from the Casino. " + dateTime.format(LocalDateTime.now()) + "</span>");
			}
			Integer sGold = (Integer) session.getAttribute("totalGold");
			System.out.println(sGold);
			session.setAttribute("totalGold", sGold + gold);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String resetGame(HttpSession session) {
		session.removeAttribute("activities");
		session.removeAttribute("totalGold");
		return "redirect:/";
	}
}
