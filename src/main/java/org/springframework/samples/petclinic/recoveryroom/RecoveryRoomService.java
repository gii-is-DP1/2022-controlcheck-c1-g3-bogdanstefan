package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecoveryRoomService {

	private RecoveryRoomRepository repository;

	@Autowired
	public RecoveryRoomService(RecoveryRoomRepository repository) {
		this.repository = repository;
	}
    public List<RecoveryRoom> getAll(){
        return repository.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes() {
        return repository.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return repository.getRecoveryRoomType(typeName);
    }

    @Transactional(rollbackFor = DuplicatedRoomNameException.class)
    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
    	RecoveryRoom room = repository.findByName(p.getName());
    	if (room == null) {
    		return repository.save(p);   
    	} else {
    		throw new DuplicatedRoomNameException();
    	}        
    }
}