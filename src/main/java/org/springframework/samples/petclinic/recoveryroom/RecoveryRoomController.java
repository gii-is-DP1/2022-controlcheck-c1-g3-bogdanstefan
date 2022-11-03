package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
	
	private static final String VIEW_ROOM_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
    private static final String WELCOME = "welcome";

    private RecoveryRoomService recoveryRoomService;

    @Autowired
    public RecoveryRoomController(RecoveryRoomService service) {
    	this.recoveryRoomService = service;
    }

    @GetMapping("/create") 	
    public String initProduct(ModelMap map) {
    	map.addAttribute("recoveryRoom", new RecoveryRoom());
    	map.addAttribute("types", recoveryRoomService.getAllRecoveryRoomTypes());
    	return VIEW_ROOM_FORM;
    }
    
    @PostMapping(path = "/create")
    public String createProduct(@Valid RecoveryRoom recoveryRoom, BindingResult br, ModelMap map) {
        if(!br.hasErrors()){
        	try {
        		recoveryRoomService.save(recoveryRoom);
			} catch (DuplicatedRoomNameException e) {
				e.printStackTrace();
			}
            map.addAttribute("message", "Product succesfully saved");
            return WELCOME;
        } else {
            map.addAttribute("recoveryRoom", recoveryRoom);
            map.addAttribute("types", recoveryRoomService.getAllRecoveryRoomTypes());
        }
        return VIEW_ROOM_FORM;
    }
}
