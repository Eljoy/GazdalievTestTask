package com.sprhib.controller;

import com.sprhib.model.Disk;
import com.sprhib.model.TakenDisk;
import com.sprhib.service.DiskService;
import com.sprhib.service.TakenDiskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.LinkedList;

/**
 * Created by Home on 17.01.2015.
 */
@Controller
@RequestMapping(value = "/takendisk")
public class TakenDiskController {
    @Autowired
    private DiskService diskService;

    @Autowired
    private TakenDiskService takenDiskService;

    @RequestMapping(value = "/getdisk/{id}", method = RequestMethod.GET)
    public ModelAndView gettingOtherDisk(@PathVariable Integer id, Principal principal){
        ModelAndView modelAndView = new ModelAndView("home");
        Disk disk = diskService.getDisk(id);
        TakenDisk takenDisk = new TakenDisk();

        takenDisk.setName(disk.getName());
        takenDisk.setDescription(disk.getDescription());
        takenDisk.setOwner(disk.getOwner());
        takenDisk.setBorrowed(principal.getName());

        diskService.deleteDisk(id);
        takenDiskService.getOtherDisk(takenDisk);
        String message = "Disk was borrowed.";
        modelAndView.addObject("message",message);
        return modelAndView;
    }

    @RequestMapping(value = "/giveback/{id}", method = RequestMethod.GET)
    public ModelAndView givingBack(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        TakenDisk takenDisk = takenDiskService.getTakenDisk(id);
        Disk disk = new Disk();

        disk.setName(takenDisk.getName());
        disk.setDescription(takenDisk.getDescription());
        disk.setOwner(takenDisk.getOwner());
        takenDiskService.deleteTakenDisk(id);
        diskService.addDisk(disk);
        String message = "Disk was returned.";
        modelAndView.addObject("message",message);
        return modelAndView;
    }


    @RequestMapping(value = "/getback/{id}", method = RequestMethod.GET)
    public ModelAndView gettingBack(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        TakenDisk takenDisk = takenDiskService.getTakenDisk(id);
        Disk disk = new Disk();

        disk.setName(takenDisk.getName());
        disk.setDescription(takenDisk.getDescription());
        disk.setOwner(takenDisk.getOwner());

        takenDiskService.deleteTakenDisk(id);
        diskService.addDisk(disk);

        String message = "Disk was gotten back.";
        modelAndView.addObject("message",message);
        return modelAndView;

    }

    @RequestMapping(value = "/takenbyuser")
    public ModelAndView listOfTakenDisks(Principal principal){
        ModelAndView modelAndView = new ModelAndView("disks-taken-by-user");
        List<TakenDisk> outList = new LinkedList<>();
        List<TakenDisk> list = takenDiskService.getTakenDisks();
        for (TakenDisk takenDisk : list) {
            if(takenDisk.getBorrowed().equals(principal.getName())) {
               outList.add(takenDisk);
            }
        }
        modelAndView.addObject("takenbyuser", outList);
        return modelAndView;
    }
    @RequestMapping(value = "/takenbyotheruser")
    public ModelAndView listOfTakenDisksByOther(Principal principal){
        ModelAndView modelAndView = new ModelAndView("disks-taken-by-other");
        List<TakenDisk> ByOtherList = new LinkedList<>();
        List<TakenDisk> list = takenDiskService.getTakenDisks();
        for (TakenDisk takenDisk : list) {
            if(!takenDisk.getBorrowed().equals(principal.getName())) {
                ByOtherList.add(takenDisk);
            }
        }
        modelAndView.addObject("takenbyother", ByOtherList);
        return modelAndView;
    }

}
