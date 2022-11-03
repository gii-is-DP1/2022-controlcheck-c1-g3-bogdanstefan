package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType> {

	RecoveryRoomService recoveryRoomService;
	
	@Autowired
	public RecoveryRoomTypeFormatter(RecoveryRoomService recoveryRoomService) {
		this.recoveryRoomService = recoveryRoomService;
	}
	
    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	RecoveryRoomType recoveryRoomType = this.recoveryRoomService.getRecoveryRoomType(text);
    	if (recoveryRoomType == null) {
    		throw new ParseException("Recovery room not found:" + text, 0);
    	} else {
    		return recoveryRoomType;
    	}
    }  
}