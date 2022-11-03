package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {
	
    List<RecoveryRoom> findAll();
    
    @Query("SELECT recoveryRoomType FROM RecoveryRoomType recoveryRoomType")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    Optional<RecoveryRoom> findById(int id);
    
    RecoveryRoom save(RecoveryRoom p);
    
    //List<RecoveryRoomType> findAllRecoveryRoomTypes();
    //RecoveryRoomType getRecoveryRoomType(String name);
    RecoveryRoom findByName(String name);
    
    @Query("SELECT recoveryRoomType FROM RecoveryRoomType recoveryRoomType WHERE recoveryRoomType.name LIKE :name%")
    RecoveryRoomType getRecoveryRoomType(String name);
}