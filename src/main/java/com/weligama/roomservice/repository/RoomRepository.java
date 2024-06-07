package com.weligama.roomservice.repository;

import com.weligama.roomservice.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
}
