package com.cricinfo.controllers;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cricinfo.model.CricResponse;
import com.cricinfo.model.Player;
import com.cricinfo.templateutility.RestTemplateUtility;
import com.google.gson.Gson;

@Controller
public class CricInfoController {
	@RequestMapping(value="/regPlayer" , method=RequestMethod.POST)
	public String registerPlayer(Model model,Player player){
		System.out.println("Palyer Id : " + player.getPalyerId());
		Gson gson = new Gson();
		String jsonPlayerReq = gson.toJson(player);
		String URL = "http://localhost:2017/live-cricket/api/cricketUpdates/regPlayer";
		HttpMethod methodType = HttpMethod.POST;
		MediaType mediaType = MediaType.APPLICATION_JSON;
		String body = RestTemplateUtility.triggerService(jsonPlayerReq, URL, methodType, mediaType);
		CricResponse fromJsonTojava = gson.fromJson(body, CricResponse.class);
		System.out.println("ERROR CODE : " + fromJsonTojava.getErrorCode());
		System.out.println("ERROR MESSAGE : " + fromJsonTojava.getErrorMessage());
		System.out.println("Response Data  : " +fromJsonTojava.getResponseData());
		if(fromJsonTojava.getErrorCode().equals("000")){
			fromJsonTojava.setErrorMessage("Player Successfully Registerd");
			model.addAttribute("message", fromJsonTojava.getErrorMessage());
			return "home";
		}
		model.addAttribute("message", fromJsonTojava.getErrorMessage());
		return "home";
	}

}
