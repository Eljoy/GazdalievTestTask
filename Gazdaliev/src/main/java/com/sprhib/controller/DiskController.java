package com.sprhib.controller;

import java.security.Principal;
import java.util.List;

import com.sprhib.service.DiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Disk;

@Controller
@RequestMapping(value="/disk")
public class DiskController {
	
	@Autowired
	private DiskService diskService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addDiskPage() {
		ModelAndView modelAndView = new ModelAndView("add-disk-form");
		modelAndView.addObject("disk", new Disk());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingDisk(@ModelAttribute Disk disk, Principal principal) {
        disk.setOwner(principal.getName());
		ModelAndView modelAndView = new ModelAndView("home");
		diskService.addDisk(disk);
		
		String message = "Disk was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfDisks() {
		ModelAndView modelAndView = new ModelAndView("list-of-disks");
		List<Disk> disks = diskService.getDisks();
		modelAndView.addObject("disks", disks);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editDiskPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-disk-form");
		Disk disk = diskService.getDisk(id);
		modelAndView.addObject("disk", disk);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingDisk(@ModelAttribute Disk disk, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		diskService.updateDisk(disk);
		
		String message = "Disk was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteDisk(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		diskService.deleteDisk(id);
		String message = "Disk was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
