package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

	@Autowired
	private RecoveryRoomService recoveryRoomService;
	
    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	RecoveryRoomType recoveryRoomType = recoveryRoomService.getRecoveryRoomType(text);
    	if (recoveryRoomType != null) {
    		return recoveryRoomType;
    	} else {
    		throw new ParseException("Este tipo de sala" + text + " ya no se encuentra.", 0);
    	}
    }
    
}
