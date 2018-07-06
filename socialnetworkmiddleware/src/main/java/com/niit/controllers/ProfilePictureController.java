package com.niit.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.dao.ProfilePictureDao;
import com.niit.model.ErrorClazz;
import com.niit.model.ProfilePicture;

@Controller
public class ProfilePictureController {
	@Autowired

	private ProfilePictureDao profilePictureDao;
	@RequestMapping(value="/updateprofiepic",method=RequestMethod.POST)
	
  public ResponseEntity<?> uploadProfilePicture(@RequestParam CommonsMultipartFile image ,HttpSession session){
		 String email=(String)session.getAttribute("email");
			if(email==null){
		     ErrorClazz errorClazz=new ErrorClazz(7,"Unauthorized access..please login");
			 return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
		  }
			ProfilePicture profilePicture=new ProfilePicture();
			profilePicture.setEmail(email);
			profilePicture.setImage(image.getBytes());
			profilePictureDao.saveProfilePicture(profilePicture);
			return new  ResponseEntity<ProfilePicture>(profilePicture,HttpStatus.OK);	
}
	
	//byte[] is  for  src attribute of  an image  tag 

	@RequestMapping(value="/getimage/{email:.+}",method=RequestMethod.GET)
	public @ResponseBody byte[] getImage(@PathVariable String email,HttpSession session){
		String auth=(String)session.getAttribute("email");
		if(auth==null)
			return null;
		ProfilePicture profilePicture=profilePictureDao.getProfilePicture(email);
	if(profilePicture==null)
		return null;
		return profilePicture.getImage();
	}
	}
