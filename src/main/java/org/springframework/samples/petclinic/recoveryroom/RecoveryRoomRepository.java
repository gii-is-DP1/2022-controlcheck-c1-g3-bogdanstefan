package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {
    List<RecoveryRoom> findAll();
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    //List<RecoveryRoomType> findAllRecoveryRoomTypes();
    //RecoveryRoomType getRecoveryRoomType(String name);
    RecoveryRoom findByName(String name);
    
    @Query("SELECT recoveryRoomType FROM RecoveryRoomType recoveryRoomType")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    @Query("SELECT recoveryRoomType FROM RecoveryRoomType recoveryRoomType WHERE recoveryRoomType.name = :name")
    RecoveryRoomType getRecoveryRoomType(@Param("name") String name);
}
